package com.liverpool.orders.infrastructure.adapter.in.rest.dto;

public class OrderDetailDto {

    private String orderRef;
    private String itemId;
    private Integer cantidad;
    private String canalDeVenta;
    private String estatusPedido;
    private String displayName;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String orderRef, String itemId, Integer cantidad,
                          String canalDeVenta, String estatusPedido, String displayName) {
        this.orderRef = orderRef;
        this.itemId = itemId;
        this.cantidad = cantidad;
        this.canalDeVenta = canalDeVenta;
        this.estatusPedido = estatusPedido;
        this.displayName = displayName;
    }

    // Getters y Setters
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
