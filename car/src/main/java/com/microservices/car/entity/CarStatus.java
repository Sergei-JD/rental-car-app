package com.microservices.car.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CarStatus {
    READY,
    REPAIR,
    SERVICE,
    WASH,
    RENT;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
