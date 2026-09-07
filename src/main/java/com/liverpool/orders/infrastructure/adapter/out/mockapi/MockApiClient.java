package com.liverpool.orders.infrastructure.adapter.out.mockapi;

import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.ItemResponseDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.OrderResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class MockApiClient {

    private final RestClient restClient;

    public MockApiClient(RestClient.Builder builder) {
        this.restClient = builder.build();
    }

    public List<OrderResponseDto> fetchPedidos() {
        return restClient.get()
                .uri("https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/pedidos")
                .retrieve()
                .body(new ParameterizedTypeReference<List<OrderResponseDto>>() {});
    }

    public List<ItemResponseDto> fetchItems() {
        return restClient.get()
                .uri("https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/items")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ItemResponseDto>>() {});
    }
}
