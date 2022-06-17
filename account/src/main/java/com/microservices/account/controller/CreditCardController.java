package com.microservices.account.controller;

import com.microservices.account.dto.create.CreditCardCreateDTO;
import com.microservices.account.dto.update.CreditCardUpdateDTO;
import com.microservices.account.dto.view.CreditCardViewDTO;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @GetMapping
    public ResponseEntity<Page<CreditCardViewDTO>> getAllCreditCards(Pageable pageable) {
        Page<CreditCardViewDTO> creditCards = creditCardService.getAllCreditCards(pageable);

        return new ResponseEntity<>(creditCards, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<CreditCardViewDTO>> getAllCreditCardsByAccountId(@PathVariable(name = "id") Long id, Pageable pageable) {
        Page<CreditCardViewDTO> creditCards = creditCardService.getAllCreditCardsByAccountId(id, pageable);

        return new ResponseEntity<>(creditCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCardViewDTO> getCreditCardById(@PathVariable(name = "id") Long id) {
        CreditCardViewDTO creditCardViewDTO = creditCardService.getCreditCardById(id);

        return new ResponseEntity<>(creditCardViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreditCardCreateDTO> createCreditCard(@RequestBody @Valid CreditCardCreateDTO creditCardCreateDTO) {
        CreditCardCreateDTO addCreditCard = creditCardService.createCreditCard(creditCardCreateDTO);

        return new ResponseEntity<>(addCreditCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditCardUpdateDTO> updateCreditCard(@PathVariable(name = "id") Long id,
                                                                @RequestBody @Valid CreditCardUpdateDTO creditCardUpdateDTO) {
        CreditCardUpdateDTO updateCreditCard = creditCardService.updateCreditCard(id, creditCardUpdateDTO);

        return new ResponseEntity<>(updateCreditCard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCreditCard(@PathVariable(name = "id") Long id) {
        boolean deleteCreditCard = creditCardService.deleteCreditCard(id);

        return new ResponseEntity<>(deleteCreditCard, HttpStatus.OK);
    }
}
