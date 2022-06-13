package com.microservices.order.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InvoiceStatus {
    CREATED,
    SENT,
    PAID;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
