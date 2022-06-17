package com.microservices.account.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CreditCardType {
    VISA,
    MASTERCARD,
    AMERICAN_EXPRESS;

    @JsonValue
    public String jsonValue() {
        return name().toLowerCase();
    }
}
