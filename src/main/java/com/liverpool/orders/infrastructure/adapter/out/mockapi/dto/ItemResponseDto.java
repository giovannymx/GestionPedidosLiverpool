package com.liverpool.orders.infrastructure.adapter.out.mockapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemResponseDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("itemId")
    private String itemId;

    @JsonProperty("skuId")
    private String skuId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("deliveryStatus")
    private String deliveryStatus;

    // Constructor vacío necesario para Jackson
    public ItemResponseDto() {}

    public ItemResponseDto(String id, String itemId, String skuId, Integer quantity, String displayName, String deliveryStatus) {
        this.id = id;
        this.itemId = itemId;
        this.skuId = skuId;
        this.quantity = quantity;
        this.displayName = displayName;
        this.deliveryStatus = deliveryStatus;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getSkuId() { return skuId; }
    public void setSkuId(String skuId) { this.skuId = skuId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }
}