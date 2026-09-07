package com.liverpool.orders.infrastructure.adapter.in.rest.dto;

public class SearchOrderRequest {
    private String query; // Texto libre para type-ahead (orderRef, orderStatus, storeName o displayName)

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }
}
