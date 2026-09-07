package com.liverpool.orders.infrastructure.adapter.in.rest;

import com.liverpool.orders.application.usecase.OrderSearchUseCase;
import com.liverpool.orders.infrastructure.adapter.in.rest.dto.OrderSearchResponseDto;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderSearchController {

    private final OrderSearchUseCase orderSearchUseCase;

    public OrderSearchController(OrderSearchUseCase orderSearchUseCase) {
        this.orderSearchUseCase = orderSearchUseCase;
    }

    @GetMapping("/search")
    public ResponseEntity<List<OrderSearchResponseDto>> searchOrders(
            @RequestParam(name = "q", required = false, defaultValue = "") String query) {
        return ResponseEntity.ok(orderSearchUseCase.searchOrders(query.trim()));
    }
}