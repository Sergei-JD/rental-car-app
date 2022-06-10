package com.microservices.account.controller;

import com.microservices.account.dto.request.AccountRequestDTO;
import com.microservices.account.dto.request.AccountUpdateRequestDTO;
import com.microservices.account.dto.request.UserRequestDTO;
import com.microservices.account.dto.request.UserUpdateRequestDTO;
import com.microservices.account.dto.response.AccountResponseDTO;
import com.microservices.account.dto.response.UserResponseDTO;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<Page<AccountResponseDTO>> getAllAccounts(Pageable pageable) {
        Page<AccountResponseDTO> accounts = accountService.getAllAccounts(pageable);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable(name = "id") Long id) {
        Optional<AccountResponseDTO> accountResponseDTO = accountService.getAccountById(id);
        return accountResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "Account with this id: " + id + " does not exist")
                );
    }

    @GetMapping("/nickname")
    public ResponseEntity<AccountResponseDTO> getAccountByNickName(@RequestParam(name = "nickname") String nickName) {
        Optional<AccountResponseDTO> accountResponseDTO = accountService.getAccountByNickName(nickName);
        return accountResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "Account with this nickName: " + nickName + " does not exist")
                );
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody @Valid AccountRequestDTO accountRequestDTO) {
        AccountResponseDTO addAccount = accountService.createAccount(accountRequestDTO);
        return new ResponseEntity<>(addAccount, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccountResponseDTO> updateAccount(@RequestBody AccountUpdateRequestDTO accountUpdateRequestDTO) {
        AccountResponseDTO updatedAccount = accountService.updateAccount(accountUpdateRequestDTO);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
    }
}
