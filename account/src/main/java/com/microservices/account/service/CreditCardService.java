package com.microservices.account.service;

import com.microservices.account.entity.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreditCardService {

    Page<CreditCard> getAllCreditCards(Pageable pageable);

    Page<CreditCard> getAllCreditCardsByAccountId(Long accountId, Pageable pageable);

    CreditCard getCreditCardById(Long creditCardId);

    CreditCard createCreditCard(CreditCard creditCard);

    CreditCard updateCreditCard(CreditCard creditCard);

    boolean deleteCreditCard(Long creditCardId);
}
