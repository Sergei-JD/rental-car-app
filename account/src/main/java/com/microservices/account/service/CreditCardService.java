package com.microservices.account.service;

import com.microservices.account.dto.request.CreditCardRequestDTO;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CreditCardService {

    Page<CreditCardResponseDTO> getAllCreditCards(Pageable pageable);

    Optional<CreditCardResponseDTO> getAllCreditCardsByAccountId(Long accountId);

    Optional<CreditCardResponseDTO> getCreditCardById(long creditCardId);

    CreditCardResponseDTO createCreditCard(CreditCardRequestDTO creditCardRequestDTO);

    CreditCardResponseDTO updateCreditCard(Long creditCardId, CreditCardRequestDTO creditCardRequestDTO);

    boolean deleteCreditCard(long creditCardId);
}
