package com.liverpool.orders.infrastructure.adapter.out.mockapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponseDto {

    private String id;
    private String userId;
    private String orderRef;
    private String itemId;
    private Integer cantidad;
    private String canalDeVenta;
    private String estatusPedido;

    public OrderResponseDto() {
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCanalDeVenta() {
        return canalDeVenta;
    }

    public void setCanalDeVenta(String canalDeVenta) {
        this.canalDeVenta = canalDeVenta;
    }

    public String getEstatusPedido() {
        return estatusPedido;
    }

    public void setEstatusPedido(String estatusPedido) {
        this.estatusPedido = estatusPedido;
    }
}
