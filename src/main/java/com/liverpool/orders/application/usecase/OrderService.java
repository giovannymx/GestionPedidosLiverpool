package com.liverpool.orders.application.usecase;

import com.liverpool.orders.infrastructure.adapter.in.rest.dto.OrderDetailDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.MockApiClient;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.ItemResponseDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final MockApiClient mockApiClient;

    public OrderService(MockApiClient mockApiClient) {
        this.mockApiClient = mockApiClient;
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
}
