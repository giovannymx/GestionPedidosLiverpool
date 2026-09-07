package com.liverpool.orders.infrastructure.adapter.in.rest.dto;

import java.util.List;

public class OrderSearchResponseDto {
    private String orderRef;
    private String orderStatus;
    private String storeName;
    private List<ItemDto> items;

    public String getOrderRef() { return orderRef; }
    public void setOrderRef(String orderRef) { this.orderRef = orderRef; }

    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public List<ItemDto> getItems() { return items; }
    public void setItems(List<ItemDto> items) { this.items = items; }

    public static class ItemDto {
        private String displayName;

        public ItemDto() {}
        public ItemDto(String displayName) { this.displayName = displayName; }

        public String getDisplayName() { return displayName; }
        public void setDisplayName(String displayName) { this.displayName = displayName; }
    }
}