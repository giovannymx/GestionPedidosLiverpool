package com.liverpool.orders.domain.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class OrderEmbedded {

    @Field("orderRef")
    private String orderRef;

    public OrderEmbedded() {
    }

    public OrderEmbedded(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }
}