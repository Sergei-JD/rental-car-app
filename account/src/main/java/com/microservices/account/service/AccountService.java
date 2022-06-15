package com.microservices.account.service;

import com.microservices.account.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {

    Page<Account> getAllAccounts(Pageable pageable);

    Account getAccountById(Long accountId);

    Account getAccountByNickName(String nickName);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    boolean deleteAccount(Long accountId);
}
