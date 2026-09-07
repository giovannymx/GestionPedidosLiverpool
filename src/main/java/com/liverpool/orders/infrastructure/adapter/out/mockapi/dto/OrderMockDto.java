package com.liverpool.orders.infrastructure.adapter.out.mockapi.dto;

import java.util.List;

public class OrderMockDto {
    private String orderRef;
    private String orderStatus;
    private String storeName;
    private List<String> items;

    public String getOrderRef() { return orderRef; }
    public void setOrderRef(String orderRef) { this.orderRef = orderRef; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }
}