package com.liverpool.orders.infrastructure.adapter.out.mongo;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "orders")
public class OrderDocument {

    @Id
    private String id;

    @Field("userId")
    private String userId;

    @Field("orderRef")
    private String orderRef;

    @Field("orderStatus")
    private String orderStatus;

    @Field("storeName")
    private String storeName;

    @Field("fechaEstimadaEntrega")
    private LocalDateTime fechaEstimadaEntrega;

    @Field("items")
    private List<OrderItemDocument> items;

    public OrderDocument() {
    }

    public OrderDocument(String id, String userId, String orderRef, String orderStatus,
                         String storeName, LocalDateTime fechaEstimadaEntrega,
                         List<OrderItemDocument> items) {
        this.id = id;
        this.userId = userId;
        this.orderRef = orderRef;
        this.orderStatus = orderStatus;
        this.storeName = storeName;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.items = items;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public LocalDateTime getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDateTime fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public List<OrderItemDocument> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDocument> items) {
        this.items = items;
    }

    // Clase interna o estática embebida para representar la lista de ítems del pedido
    public static class OrderItemDocument {

        @Field("itemId")
        private String itemId;

        @Field("cantidad")
        private Integer cantidad;

        @Field("canalDeVenta")
        private String canalDeVenta;

        @Field("displayName")
        private String displayName;

        public OrderItemDocument() {
        }

        public OrderItemDocument(String itemId, Integer cantidad, String canalDeVenta, String displayName) {
            this.itemId = itemId;
            this.cantidad = cantidad;
            this.canalDeVenta = canalDeVenta;
            this.displayName = displayName;
        }

        // Getters y Setters
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

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }
}
