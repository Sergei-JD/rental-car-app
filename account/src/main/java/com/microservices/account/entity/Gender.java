package com.microservices.account.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE,
    FEMALE,
    OTHER;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
