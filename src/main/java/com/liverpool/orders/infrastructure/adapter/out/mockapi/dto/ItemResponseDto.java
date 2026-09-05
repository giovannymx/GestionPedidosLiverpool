package com.liverpool.orders.infrastructure.adapter.out.mockapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemResponseDto {

    private String id;

    @JsonProperty("itemId")
    private String itemId;

    @JsonProperty("displayName")
    private String displayName;

    public ItemResponseDto() {
    }

    public ItemResponseDto(String id, String itemId, String displayName) {
        this.id = id;
        this.itemId = itemId;
        this.displayName = displayName;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
