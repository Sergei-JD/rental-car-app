package com.microservices.account.service;

import com.microservices.account.dto.create.CreateCreditCardDTO;
import com.microservices.account.dto.update.UpdateCreditCardDTO;
import com.microservices.account.dto.view.ViewCreditCardDTO;
import com.microservices.account.entity.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreditCardService {

    Page<ViewCreditCardDTO> getAllCreditCards(Pageable pageable);

    Page<ViewCreditCardDTO> getAllCreditCardsByAccountId(Long accountId, Pageable pageable);

    CreditCard getCreditCardById(Long creditCardId);

    Long createCreditCard(CreateCreditCardDTO createCreditCardDTO);

    void updateCreditCard(Long creditCardId, UpdateCreditCardDTO updateCreditCardDTO);

    boolean deleteCreditCard(Long creditCardId);
}
