package com.microservices.account.service;

import com.microservices.account.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountService {

    Page<Account> getAllAccounts(Pageable pageable);

    Optional<Account> getAccountById(Long accountId);

    Optional<Account> getAccountByNickName(String nickName);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    boolean deleteAccount(Long accountId);
}
