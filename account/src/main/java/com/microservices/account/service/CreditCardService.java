package com.microservices.account.service;

import com.microservices.account.dto.request.CreditCardRequestDTO;
import com.microservices.account.dto.request.CreditCardUpdateRequestDTO;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CreditCardService {

    Page<CreditCardResponseDTO> getAllCreditCards(Pageable pageable);

    Page<CreditCardResponseDTO> getAllCreditCardsByAccountId(Long accountId, Pageable pageable);

    Optional<CreditCardResponseDTO> getCreditCardById(Long creditCardId);

    CreditCardResponseDTO createCreditCard(CreditCardRequestDTO creditCardRequestDTO);

    CreditCardResponseDTO updateCreditCard(CreditCardUpdateRequestDTO creditCardUpdateRequestDTO);

    boolean deleteCreditCard(Long creditCardId);
}
