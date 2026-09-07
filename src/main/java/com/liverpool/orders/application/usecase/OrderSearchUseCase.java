package com.liverpool.orders.application.usecase;

import com.liverpool.orders.domain.util.TextSearchUtil;
import com.liverpool.orders.infrastructure.adapter.in.rest.dto.OrderSearchResponseDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.ExternalApiClient;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.ItemResponseDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.OrderMockDto;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OrderSearchUseCase {

    private final ExternalApiClient externalApiClient;

    public OrderSearchUseCase(ExternalApiClient externalApiClient) {
        this.externalApiClient = externalApiClient;
    }

    public List<OrderSearchResponseDto> searchOrders(String query) {
        if (query == null || query.isBlank()) {
            return Collections.emptyList();
        }

        List<OrderMockDto> pedidos = externalApiClient.fetchPedidos();
        List<ItemResponseDto> items = externalApiClient.fetchItems();

        // Crear mapa para resolución rápida de itemId -> ItemResponseDto
        Map<String, ItemResponseDto> itemMap = items.stream()
                .collect(Collectors.toMap(ItemResponseDto::getItemId, item -> item, (k1, k2) -> k1));

        List<OrderSearchResponseDto> results = new ArrayList<>();

        for (OrderMockDto pedido : pedidos) {
            // Mapear items asociados a este pedido
            List<ItemResponseDto> orderItems = new ArrayList<>();
            if (pedido.getItems() != null) {
                for (String itemId : pedido.getItems()) {
                    if (itemMap.containsKey(itemId)) {
                        orderItems.add(itemMap.get(itemId));
                    }
                }
            }

            // Evaluar coincidencia en orderRef, orderStatus o storeName
            boolean matchInOrder = TextSearchUtil.matches(pedido.getOrderRef(), query)
                    || TextSearchUtil.matches(pedido.getOrderStatus(), query)
                    || TextSearchUtil.matches(pedido.getStoreName(), query);

            // Evaluar coincidencia en displayName de alguno de sus items
            boolean matchInItems = orderItems.stream()
                    .anyMatch(item -> TextSearchUtil.matches(item.getDisplayName(), query));

            if (matchInOrder || matchInItems) {
                OrderSearchResponseDto dto = new OrderSearchResponseDto();
                dto.setOrderRef(pedido.getOrderRef());
                dto.setOrderStatus(pedido.getOrderStatus());
                dto.setStoreName(pedido.getStoreName());
                dto.setItems(orderItems.stream()
                        .map(i -> new OrderSearchResponseDto.ItemDto(i.getDisplayName()))
                        .collect(Collectors.toList()));

                results.add(dto);
            }
        }

        return results;
    }
}