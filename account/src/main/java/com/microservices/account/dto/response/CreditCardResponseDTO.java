package com.microservices.account.dto.response;

import com.microservices.account.entity.Account;
import com.microservices.account.entity.CreditCardType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardResponseDTO {

    private Long id;

    private CreditCardType creditCardType;

    private String cardNumber;

    private Instant dateOfIssue;

    private Instant expirationDate;

    private String cvvCode;

    private String nameCardOwner;

    private BigDecimal balance;

    private Account account;
}
