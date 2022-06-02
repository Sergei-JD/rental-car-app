package com.microservices.account.service;

import com.microservices.account.dto.CreditCardRequestDTO;
import com.microservices.account.dto.CreditCardResponseFullDTO;
import com.microservices.account.dto.CreditCardResponseViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {

    Page<CreditCardResponseViewDTO> getAllCreditCards(Pageable pageable);

    List<CreditCardResponseFullDTO> getAllCreditCardsByAccountId(Long accountId);

    Optional<CreditCardResponseViewDTO> getCreditCardById(long creditCardId);

    CreditCardRequestDTO createCreditCard(CreditCardRequestDTO creditCardRequestDTO);

    CreditCardResponseFullDTO updateCreditCard(CreditCardResponseFullDTO creditCardResponseFullDTO);

    boolean deleteCreditCard(long creditCardId);
}
