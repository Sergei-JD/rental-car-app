package com.microservices.order.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    PENDING,
    CONFIRMED,
    CANCELLED;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
