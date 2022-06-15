package com.microservices.account.controller;

import com.microservices.account.dto.request.CreditCardRequestDTO;
import com.microservices.account.dto.request.CreditCardUpdateRequestDTO;
import com.microservices.account.dto.response.CreditCardResponseDTO;
import com.microservices.account.mapper.request.CreditCardRequestDTOToCreditCardMapper;
import com.microservices.account.mapper.request.CreditCardUpdateRequestDTOToCreditCardMapper;
import com.microservices.account.mapper.response.CreditCardToCreditCardResponseDTOMapper;
import com.microservices.account.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cards")
public class CreditCardController {

    private final CreditCardService creditCardService;
    private final CreditCardRequestDTOToCreditCardMapper creditCardRequestDTOToCreditCardMapper;
    private final CreditCardToCreditCardResponseDTOMapper creditCardToCreditCardResponseDTOMapper;
    private final CreditCardUpdateRequestDTOToCreditCardMapper creditCardUpdateRequestDTOToCreditCardMapper;

    @GetMapping
    public ResponseEntity<List<CreditCardResponseDTO>> getAllCreditCards(Pageable pageable) {
        List<CreditCardResponseDTO> cards = creditCardService.getAllCreditCards(pageable).stream()
                .map(creditCardToCreditCardResponseDTOMapper::convert)
                .toList();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

//    @GetMapping("/account/{id}")
//    public ResponseEntity<Page<CreditCardResponseDTO>> getAllCreditCardsByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
//        Page<CreditCardResponseDTO> cards = creditCardService.getAllCreditCardsByAccountId(id, pageable);
//        return new ResponseEntity<>(cards, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CreditCardResponseDTO> getCreditCardById(@PathVariable(name = "id") Long id) {
//        Optional<CreditCardResponseDTO> creditCardResponseDTO = creditCardService.getCreditCardById(id);
//        return creditCardResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
//                .orElseThrow(() -> new RuntimeException(
//                        "CreditCard with this id: " + id + " does not exist")
//                );
//    }
//
//    @PostMapping
//    public ResponseEntity<CreditCardResponseDTO> createCreditCard(@RequestBody @Valid CreditCardRequestDTO creditCardRequestDTO) {
//        CreditCardResponseDTO addCreditCard = creditCardService.createCreditCard(creditCardRequestDTO);
//        return new ResponseEntity<>(addCreditCard, HttpStatus.CREATED);
//    }
//
//    @PutMapping
//    public ResponseEntity<CreditCardResponseDTO> updateCreditCard(@RequestBody @Valid CreditCardUpdateRequestDTO creditCardUpdateRequestDTO) {
//        CreditCardResponseDTO updatedCreditCard = creditCardService.updateCreditCard(creditCardUpdateRequestDTO);
//        return new ResponseEntity<>(updatedCreditCard, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCreditCard(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(creditCardService.deleteCreditCard(id), HttpStatus.OK);
    }
}
