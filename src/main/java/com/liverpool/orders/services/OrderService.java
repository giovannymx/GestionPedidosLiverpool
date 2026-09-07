package com.liverpool.orders.services;

import com.liverpool.orders.infrastructure.adapter.in.rest.dto.OrderDetailDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.MockApiClient;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.ItemResponseDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.OrderResponseDto;
import com.liverpool.orders.infrastructure.adapter.out.mongo.OrderDocument;
import com.liverpool.orders.infrastructure.adapter.out.mongo.SearchOrderAdapter;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final MockApiClient mockApiClient;
    private final SearchOrderAdapter searchOrderAdapter;

    public OrderService(MockApiClient mockApiClient, SearchOrderAdapter searchOrderAdapter) {
        this.mockApiClient = mockApiClient;
        this.searchOrderAdapter = searchOrderAdapter;
    }

    public List<OrderDetailDto> searchOrdersWithItems(String searchTerm) {
        // 1. Ejecutar la búsqueda flexible sobre los registros
        List<OrderDocument> orders = searchOrderAdapter.searchOrdersFlexible(searchTerm);

        // 2. Traer productos de la API externa /items
        List<ItemResponseDto> items = mockApiClient.fetchItems();
        Map<String, String> itemMap = items.stream()
                .collect(Collectors.toMap(ItemResponseDto::getItemId, ItemResponseDto::getDisplayName, (k1, k2) -> k1));

        // 3. Cruzar los datos para incluir el displayName enriquecido
        return orders.stream().map(order -> {
            // Transformación a OrderDetailDto adjuntando displayName desde el mapa
            return mapToDto(order, itemMap);
        }).collect(Collectors.toList());
    }

    public List<OrderDetailDto> getCombinedOrdersByUser(String userId) {
        List<OrderResponseDto> pedidos = mockApiClient.fetchPedidos();
        List<ItemResponseDto> items = mockApiClient.fetchItems();

        Map<String, ItemResponseDto> itemMap = items.stream()
                .collect(Collectors.toMap(ItemResponseDto::getItemId, item -> item, (k1, k2) -> k1));

        return pedidos.stream()
                .filter(p -> userId.equals(p.getUserId()))
                .map(ped -> {
                    ItemResponseDto item = itemMap.get(ped.getItemId());
                    return new OrderDetailDto(
                            ped.getOrderRef(),
                            ped.getItemId(),
                            ped.getCantidad(),
                            ped.getCanalDeVenta(),
                            ped.getEstatusPedido(),
                            item != null ? item.getDisplayName() : null
                    );
                })
                .collect(Collectors.toList());
    }

    // Mapea un OrderDocument a una lista de OrderDetailDto (uno por cada ítem del pedido)
    private List<OrderDetailDto> mapToDtoList(OrderDocument order, Map<String, String> itemMap) {
        if (order == null || order.getItems() == null) {
            return Collections.emptyList();
        }

        return order.getItems().stream().map(item -> {
            // Se busca el displayName en el mapa cargado desde /items; si no existe, usa el local
            String displayName = itemMap.getOrDefault(item.getItemId(), item.getDisplayName());

            return new OrderDetailDto(
                    order.getOrderRef(),
                    item.getItemId(),
                    item.getCantidad(),
                    item.getCanalDeVenta(),
                    order.getOrderStatus(),
                    displayName
            );
        }).collect(Collectors.toList());
    }

    private OrderDetailDto mapToDto(OrderDocument order, Map<String, String> itemMap) {
        if (order == null) {
            return null;
        }

        // Obtiene el primer ítem si existe
        OrderDocument.OrderItemDocument item = (order.getItems() != null && !order.getItems().isEmpty())
                ? order.getItems().get(0)
                : null;

        String itemId = item != null ? item.getItemId() : null;
        Integer cantidad = item != null ? item.getCantidad() : null;
        String canalDeVenta = item != null ? item.getCanalDeVenta() : null;

        // Cruce para obtener el displayName enriquecido de /items
        String displayName = itemMap.getOrDefault(itemId, item != null ? item.getDisplayName() : null);

        return new OrderDetailDto(
                order.getOrderRef(),
                itemId,
                cantidad,
                canalDeVenta,
                order.getOrderStatus(),
                displayName
        );
    }
}
