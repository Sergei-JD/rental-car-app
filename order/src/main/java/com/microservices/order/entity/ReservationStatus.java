package com.microservices.order.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReservationStatus {
    FREE,
    BOOKED;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
