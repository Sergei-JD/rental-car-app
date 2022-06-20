package com.microservices.account.controller;

import com.microservices.account.dto.create.CreateAccountDTO;
import com.microservices.account.dto.update.UpdateAccountDTO;
import com.microservices.account.dto.view.ViewAccountDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.mapper.AccountMapper;
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
    public ResponseEntity<Page<ViewAccountDTO>> getAllAccounts(Pageable pageable) {
        Page<ViewAccountDTO> accounts = accountService.getAllAccounts(pageable);

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewAccountDTO> getAccountById(
            @PathVariable(name = "id") Long id) {
        Account account = accountService.getAccountById(id);
        ViewAccountDTO viewAccountDTO = AccountMapper.toViewAccountDTO(account);

        return new ResponseEntity<>(viewAccountDTO, HttpStatus.OK);
    }

    @GetMapping("/nickname")
    public ResponseEntity<ViewAccountDTO> getAccountByNickName(
            @RequestParam(name = "nickname") String nickName) {
        Account account = accountService.getAccountByNickName(nickName);
        ViewAccountDTO viewAccountDTO = AccountMapper.toViewAccountDTO(account);

        return new ResponseEntity<>(viewAccountDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createAccount(
            @RequestBody @Valid CreateAccountDTO createAccountDTO) {
        Long addAccount = accountService.createAccount(createAccountDTO);

        return new ResponseEntity<>(addAccount, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAccount(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateAccountDTO updateAccountDTO) {
        accountService.updateAccount(id, updateAccountDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable(name = "id") Long id) {
        boolean deleteAccount = accountService.deleteAccount(id);

        return new ResponseEntity<>(deleteAccount, HttpStatus.OK);
    }
}
