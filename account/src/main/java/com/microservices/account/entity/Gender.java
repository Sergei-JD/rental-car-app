package com.microservices.account.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MALE,
    FEMALE;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
