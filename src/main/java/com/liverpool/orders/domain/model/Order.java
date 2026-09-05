package com.liverpool.orders.domain.model;

import java.time.LocalDateTime;

public class Order {

    private String orderRef;
    private String itemId;
    private Integer cantidad;
    private String canalDeVenta;
    private String orderStatus;
    private LocalDateTime fechaEstimadaEntrega; // Derivado del estatus
    private String storeName;
    private String displayName; // Recuperado del servicio /items

    public Order() {
    }

    public Order(String orderRef, String itemId, Integer cantidad,
                 String canalDeVenta, String orderStatus,
                 LocalDateTime fechaEstimadaEntrega, String storeName,
                 String displayName) {
        this.orderRef = orderRef;
        this.itemId = itemId;
        this.cantidad = cantidad;
        this.canalDeVenta = canalDeVenta;
        this.orderStatus = orderStatus;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.storeName = storeName;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDateTime fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
