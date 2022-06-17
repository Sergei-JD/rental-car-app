package com.microservices.account.mapper;

import com.microservices.account.dto.create.CreditCardCreateDTO;
import com.microservices.account.dto.update.CreditCardUpdateDTO;
import com.microservices.account.dto.view.CreditCardViewDTO;
import com.microservices.account.entity.CreditCard;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardMapper {

    public static CreditCardViewDTO toCreditCardViewDTO(CreditCard creditCard) {
        return Optional.ofNullable(creditCard)
                .map(existCreditCard -> CreditCardViewDTO.builder()
                        .id(creditCard.getId())
                        .creditCardType(creditCard.getCreditCardType())
                        .cardNumber(creditCard.getCardNumber())
                        .dateOfIssue(creditCard.getDateOfIssue())
                        .expirationDate(creditCard.getExpirationDate())
                        .cvvCode(creditCard.getCvvCode())
                        .nameCardOwner(creditCard.getNameCardOwner())
                        .balance(creditCard.getBalance())
                        .build())
                .orElse(null);
    }

    public static CreditCardCreateDTO toCreditCardCreateDTO(CreditCard creditCard) {
        return Optional.ofNullable(creditCard)
                .map(existCreditCard -> CreditCardCreateDTO.builder()
                        .creditCardType(creditCard.getCreditCardType())
                        .cardNumber(creditCard.getCardNumber())
                        .dateOfIssue(creditCard.getDateOfIssue())
                        .expirationDate(creditCard.getExpirationDate())
                        .cvvCode(creditCard.getCvvCode())
                        .nameCardOwner(creditCard.getNameCardOwner())
                        .balance(creditCard.getBalance())
                        .build())
                .orElse(null);
    }

    public static CreditCardUpdateDTO toCreditCardUpdateDTO(CreditCard creditCard) {
        return Optional.ofNullable(creditCard)
                .map(existCreditCard -> CreditCardUpdateDTO.builder()
                        .creditCardType(creditCard.getCreditCardType())
                        .cardNumber(creditCard.getCardNumber())
                        .dateOfIssue(creditCard.getDateOfIssue())
                        .expirationDate(creditCard.getExpirationDate())
                        .cvvCode(creditCard.getCvvCode())
                        .nameCardOwner(creditCard.getNameCardOwner())
                        .balance(creditCard.getBalance())
                        .build())
                .orElse(null);
    }
}
