package com.microservices.account.controller;

import com.microservices.account.dto.create.CreateCreditCardDTO;
import com.microservices.account.dto.update.UpdateCreditCardDTO;
import com.microservices.account.dto.view.ViewCreditCardDTO;
import com.microservices.account.entity.CreditCard;
import com.microservices.account.mapper.CreditCardMapper;
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
    public ResponseEntity<Page<ViewCreditCardDTO>> getAllCreditCards(Pageable pageable) {
        Page<ViewCreditCardDTO> creditCards = creditCardService.getAllCreditCards(pageable);

        return new ResponseEntity<>(creditCards, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Page<ViewCreditCardDTO>> getAllCreditCardsByAccountId(
            @PathVariable(name = "id") Long id, Pageable pageable) {
        Page<ViewCreditCardDTO> creditCards = creditCardService.getAllCreditCardsByAccountId(id, pageable);

        return new ResponseEntity<>(creditCards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewCreditCardDTO> getCreditCardById(
            @PathVariable(name = "id") Long id) {
        CreditCard creditCard = creditCardService.getCreditCardById(id);
        ViewCreditCardDTO viewCreditCardDTO = CreditCardMapper.toViewCreditCardDTO(creditCard);

        return new ResponseEntity<>(viewCreditCardDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createCreditCard(
            @RequestBody @Valid CreateCreditCardDTO createCreditCardDTO) {
        Long addCreditCard = creditCardService.createCreditCard(createCreditCardDTO);

        return new ResponseEntity<>(addCreditCard, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCreditCard(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateCreditCardDTO updateCreditCardDTO) {
        creditCardService.updateCreditCard(id, updateCreditCardDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCreditCard(
            @PathVariable(name = "id") Long id) {
        boolean deleteCreditCard = creditCardService.deleteCreditCard(id);

        return new ResponseEntity<>(deleteCreditCard, HttpStatus.OK);
    }
}
