package com.microservices.car.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CarType {
    UNIVERSAL,
    MINIVAN,
    SEDAN,
    COUPE,
    SUV;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
