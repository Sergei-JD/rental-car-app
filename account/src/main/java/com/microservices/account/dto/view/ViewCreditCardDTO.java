package com.microservices.account.dto.view;

import com.microservices.account.entity.CreditCardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ViewCreditCardDTO {

    private Long id;

    private CreditCardType creditCardType;

    private String cardNumber;

    private Instant dateOfIssue;

    private Instant expirationDate;

    private String cvvCode;

    private String nameCardOwner;

    private BigDecimal balance;
}
