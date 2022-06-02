package com.microservices.account.service;

import com.microservices.account.dto.AccountRequestDTO;
import com.microservices.account.dto.AccountResponseFullDTO;
import com.microservices.account.dto.AccountResponseViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountService {

    Page<AccountResponseViewDTO> getAllAccounts(Pageable pageable);

    Optional<AccountResponseViewDTO> getAccountById(long accountId);

    Optional<AccountResponseFullDTO> getAccountByNickName(String nickName);

    AccountRequestDTO createAccount(AccountRequestDTO accountRequestDTO);

    AccountResponseFullDTO updateAccount(AccountResponseFullDTO accountResponseFullDTO);

    boolean deleteAccount(long accountId);
}
