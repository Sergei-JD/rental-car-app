package com.microservices.account.service;

import com.microservices.account.dto.request.CreditCardRequestDTO;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {

    Page<CreditCardResponseDTO> getAllCreditCards(Pageable pageable);

    List<CreditCardResponseDTO> getAllCreditCardsByAccountId(Long accountId);

    Optional<CreditCardResponseDTO> getCreditCardById(long creditCardId);

    CreditCardRequestDTO createCreditCard(CreditCardRequestDTO creditCardRequestDTO);

    CreditCardResponseDTO updateCreditCard(CreditCardResponseDTO creditCardResponseDTO);

    boolean deleteCreditCard(long creditCardId);
}
