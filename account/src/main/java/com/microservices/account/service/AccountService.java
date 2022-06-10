package com.microservices.account.service;

import com.microservices.account.dto.request.AccountRequestDTO;
import com.microservices.account.dto.request.AccountUpdateRequestDTO;
import com.microservices.account.dto.response.AccountResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountService {

    Page<AccountResponseDTO> getAllAccounts(Pageable pageable);

    Optional<AccountResponseDTO> getAccountById(Long accountId);

    Optional<AccountResponseDTO> getAccountByNickName(String nickName);

    AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO);

    AccountResponseDTO updateAccount(AccountUpdateRequestDTO accountUpdateRequestDTO);

    boolean deleteAccount(Long accountId);
}
