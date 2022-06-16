package com.microservices.account.controller;

import com.microservices.account.dto.request.CreditCardRequestDTO;
import com.microservices.account.dto.request.UpdateCreditCardDTO;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import com.microservices.account.entity.CreditCard;
import com.microservices.account.mapper.request.CreditCardRequestDTOToCreditCardMapper;
import com.microservices.account.mapper.request.UpdateCreditCardDTOToCreditCardMapper;
import com.microservices.account.mapper.response.CreditCardToCreditCardResponseDTOMapper;
import com.microservices.account.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cards")
public class CreditCardController {

    private final CreditCardService creditCardService;
    private final CreditCardRequestDTOToCreditCardMapper creditCardRequestDTOToCreditCardMapper;
    private final CreditCardToCreditCardResponseDTOMapper creditCardToCreditCardResponseDTOMapper;
    private final UpdateCreditCardDTOToCreditCardMapper updateCreditCardDTOToCreditCardMapper;

    @GetMapping
    public ResponseEntity<List<CreditCardResponseDTO>> getAllCreditCards(Pageable pageable) {
        List<CreditCardResponseDTO> cards = creditCardService.getAllCreditCards(pageable).stream()
                .map(creditCardToCreditCardResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<List<CreditCardResponseDTO>> getAllCreditCardsByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
        List<CreditCardResponseDTO> cards = creditCardService.getAllCreditCardsByAccountId(id, pageable).stream()
                .map(creditCardToCreditCardResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCardResponseDTO> getCreditCardById(@PathVariable(name = "id") Long id) {
        CreditCard creditCard = creditCardService.getCreditCardById(id);
        CreditCardResponseDTO creditCardResponseDTO = creditCardToCreditCardResponseDTOMapper.convert(creditCard);

        return new ResponseEntity<>(creditCardResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreditCardResponseDTO> createCreditCard(@RequestBody @Valid CreditCardRequestDTO creditCardRequestDTO) {
        CreditCard creditCard = creditCardRequestDTOToCreditCardMapper.convert(creditCardRequestDTO);
        CreditCard createdCreditCard = creditCardService.createCreditCard(creditCard);
        CreditCardResponseDTO addCreditCard = creditCardToCreditCardResponseDTOMapper.convert(createdCreditCard);

        return new ResponseEntity<>(addCreditCard, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CreditCardResponseDTO> updateCreditCard(@RequestBody @Valid UpdateCreditCardDTO updateCreditCardDTO) {
        CreditCard creditCard = updateCreditCardDTOToCreditCardMapper.convert(updateCreditCardDTO);
        CreditCard updateCreditCard = creditCardService.updateCreditCard(creditCard);
        CreditCardResponseDTO updatedCreditCard = creditCardToCreditCardResponseDTOMapper.convert(updateCreditCard);

        return new ResponseEntity<>(updatedCreditCard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCreditCard(@PathVariable(name = "id") Long id) {
        boolean deleteCreditCard = creditCardService.deleteCreditCard(id);

        return new ResponseEntity<>(deleteCreditCard, HttpStatus.OK);
    }
}
