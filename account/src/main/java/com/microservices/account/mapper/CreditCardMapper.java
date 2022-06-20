package com.microservices.account.mapper;

import com.microservices.account.dto.create.CreateCreditCardDTO;
import com.microservices.account.dto.update.UpdateCreditCardDTO;
import com.microservices.account.dto.view.ViewCreditCardDTO;
import com.microservices.account.entity.CreditCard;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardMapper {

    public static ViewCreditCardDTO toViewCreditCardDTO(CreditCard creditCard) {
        return Optional.ofNullable(creditCard)
                .map(existCreditCard -> ViewCreditCardDTO.builder()
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

    public static CreateCreditCardDTO toCreateCreditCardDTO(CreditCard creditCard) {
        return Optional.ofNullable(creditCard)
                .map(existCreditCard -> CreateCreditCardDTO.builder()
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

    public static UpdateCreditCardDTO toUpdateCreditCardDTO(CreditCard creditCard) {
        return Optional.ofNullable(creditCard)
                .map(existCreditCard -> UpdateCreditCardDTO.builder()
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
