package com.microservices.account.controller;

import com.microservices.account.dto.create.AccountCreateDTO;
import com.microservices.account.dto.update.AccountUpdateDTO;
import com.microservices.account.dto.view.AccountViewDTO;
import com.microservices.account.service.AccountService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<Page<AccountViewDTO>> getAllAccounts(Pageable pageable) {
        Page<AccountViewDTO> accounts = accountService.getAllAccounts(pageable);

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountViewDTO> getAccountById(@PathVariable(name = "id") Long id) {
        AccountViewDTO accountViewDTO = accountService.getAccountById(id);

        return new ResponseEntity<>(accountViewDTO, HttpStatus.OK);
    }

    @GetMapping("/nickname")
    public ResponseEntity<AccountViewDTO> getAccountByNickName(@RequestParam(name = "nickname") String nickName) {
        AccountViewDTO accountViewDTO = accountService.getAccountByNickName(nickName);

        return new ResponseEntity<>(accountViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountCreateDTO> createAccount(@RequestBody @Valid AccountCreateDTO accountCreateDTO) {
        AccountCreateDTO addAccount = accountService.createAccount(accountCreateDTO);

        return new ResponseEntity<>(addAccount, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountUpdateDTO> updateAccount(@PathVariable(name = "id") Long id,
                                                          @RequestBody @Valid AccountUpdateDTO accountUpdateDTO) {
        AccountUpdateDTO updateAccount = accountService.updateAccount(id, accountUpdateDTO);

        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable(name = "id") Long id) {
        boolean deleteAccount = accountService.deleteAccount(id);

        return new ResponseEntity<>(deleteAccount, HttpStatus.OK);
    }
}
