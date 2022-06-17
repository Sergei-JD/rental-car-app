package com.microservices.account.service;

import com.microservices.account.dto.create.CreditCardCreateDTO;
import com.microservices.account.dto.update.CreditCardUpdateDTO;
import com.microservices.account.dto.view.CreditCardViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreditCardService {

    Page<CreditCardViewDTO> getAllCreditCards(Pageable pageable);

    Page<CreditCardViewDTO> getAllCreditCardsByAccountId(Long accountId, Pageable pageable);

    CreditCardViewDTO getCreditCardById(Long creditCardId);

    CreditCardCreateDTO createCreditCard(CreditCardCreateDTO creditCardCreateDTO);

    CreditCardUpdateDTO updateCreditCard(Long creditCardId, CreditCardUpdateDTO creditCardUpdateDTO);

    boolean deleteCreditCard(Long creditCardId);
}
