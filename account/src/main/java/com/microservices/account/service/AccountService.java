package com.microservices.account.service;

import com.microservices.account.dto.create.CreateAccountDTO;
import com.microservices.account.dto.update.UpdateAccountDTO;
import com.microservices.account.dto.view.ViewAccountDTO;
import com.microservices.account.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {

    Page<ViewAccountDTO> getAllAccounts(Pageable pageable);

    Account getAccountById(Long accountId);

    Account getAccountByNickName(String nickName);

    Long createAccount(CreateAccountDTO createAccountDTO);

    void updateAccount(Long accountId, UpdateAccountDTO updateAccountDTO);

    boolean deleteAccount(Long accountId);
}
