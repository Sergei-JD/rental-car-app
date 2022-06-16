package com.microservices.account.controller;

import com.microservices.account.dto.request.AccountRequestDTO;
import com.microservices.account.dto.request.UpdateAccountDTO;
import com.microservices.account.dto.response.AccountResponseDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.mapper.request.AccountRequestDTOToAccountMapper;
import com.microservices.account.mapper.request.UpdateAccountDTOToAccountMapper;
import com.microservices.account.mapper.response.AccountToAccountResponseDTOMapper;
import com.microservices.account.service.AccountService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountRequestDTOToAccountMapper accountRequestDTOToAccountMapper;
    private final AccountToAccountResponseDTOMapper accountToAccountResponseDTOMapper;
    private final UpdateAccountDTOToAccountMapper updateAccountDTOToAccountMapper;

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts(Pageable pageable) {
        List<AccountResponseDTO> accounts = accountService.getAllAccounts(pageable).stream()
                .map(accountToAccountResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable(name = "id") Long id) {
        Account account = accountService.getAccountById(id);
        AccountResponseDTO accountResponseDTO = accountToAccountResponseDTOMapper.convert(account);

        return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/nickname")
    public ResponseEntity<AccountResponseDTO> getAccountByNickName(@RequestParam(name = "nickname") String nickName) {
        Account account = accountService.getAccountByNickName(nickName);
        AccountResponseDTO accountResponseDTO = accountToAccountResponseDTOMapper.convert(account);

        return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody @Valid AccountRequestDTO accountRequestDTO) {
        Account account = accountRequestDTOToAccountMapper.convert(accountRequestDTO);
        Account createdAccount = accountService.createAccount(account);
        AccountResponseDTO addAccount = accountToAccountResponseDTOMapper.convert(createdAccount);

        return new ResponseEntity<>(addAccount, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccountResponseDTO> updateAccount(@RequestBody @Valid UpdateAccountDTO updateAccountDTO) {
        Account account = updateAccountDTOToAccountMapper.convert(updateAccountDTO);
        Account updateAccount = accountService.updateAccount(account);
        AccountResponseDTO updatedAccount = accountToAccountResponseDTOMapper.convert(updateAccount);

        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable(name = "id") Long id) {
        boolean deleteAccount = accountService.deleteAccount(id);

        return new ResponseEntity<>(deleteAccount, HttpStatus.OK);
    }
}
