package com.liverpool.orders.infrastructure.adapter.out.mockapi;

import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.ItemResponseDto;
import com.liverpool.orders.infrastructure.adapter.out.mockapi.dto.OrderMockDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ExternalApiClient {

    private final RestClient restClient;

    public ExternalApiClient() {
        this.restClient = RestClient.create();
    }

    public List<ItemResponseDto> fetchItems() {
        try {
            ItemResponseDto[] response = restClient.get()
                    .uri("https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/items")
                    .retrieve()
                    .body(ItemResponseDto[].class);
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<OrderMockDto> fetchPedidos() {
        try {
            OrderMockDto[] response = restClient.get()
                    .uri("https://6994a4eab081bc23e9c0f61e.mockapi.io/api/v1/pedidos")
                    .retrieve()
                    .body(OrderMockDto[].class);
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
