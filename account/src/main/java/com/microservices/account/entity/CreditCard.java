package com.microservices.account.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false, of =
        {"id", "creditCardType", "cardNumber", "dateOfIssue",
                "expirationDate", "cvvCode", "nameCardOwner", "balance", "account"})
@Table(name = "credit_card", schema = "PUBLIC")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "credit_card_type", nullable = false)
    private CreditCardType creditCardType;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "date_of_issue", nullable = false)
    private Instant dateOfIssue;

    @Column(name = "expiration_date", nullable = false)
    private Instant expirationDate;

    @Column(name = "cvv_code", nullable = false)
    private String cvvCode;

    @Column(name = "name_card_owner", nullable = false)
    private String nameCardOwner;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
