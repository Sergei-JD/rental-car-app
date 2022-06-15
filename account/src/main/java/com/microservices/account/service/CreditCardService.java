package com.microservices.account.service;

import com.microservices.account.entity.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CreditCardService {

    Page<CreditCard> getAllCreditCards(Pageable pageable);

    Page<CreditCard> getAllCreditCardsByAccountId(Long accountId, Pageable pageable);

    Optional<CreditCard> getCreditCardById(Long creditCardId);

    CreditCard createCreditCard(CreditCard creditCard);

    CreditCard updateCreditCard(CreditCard creditCard);

    boolean deleteCreditCard(Long creditCardId);
}
