package com.liverpool.orders.infrastructure.adapter.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Clientes & Pedidos", description = "Endpoints para gestión de clientes y consulta de pedidos")
public class UserController {

    @Operation(summary = "Buscar pedidos", description = "Filtra pedidos por orderRef, orderStatus, storeName y displayName de items con búsqueda flexible (Typeahead).")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada exitosamente")
    @GetMapping("/orders/search")
    public ResponseEntity<?> searchOrders(@RequestParam(required = false) String q) {
        // Llamada al caso de uso
        return ResponseEntity.ok().build();
    }
}
