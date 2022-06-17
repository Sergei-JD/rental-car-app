package com.microservices.account.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN,
    CUSTOMER,
    MECHANIC;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
