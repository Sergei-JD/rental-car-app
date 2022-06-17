package com.microservices.account.service;

import com.microservices.account.dto.create.AccountCreateDTO;
import com.microservices.account.dto.update.AccountUpdateDTO;
import com.microservices.account.dto.view.AccountViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {

    Page<AccountViewDTO> getAllAccounts(Pageable pageable);

    AccountViewDTO getAccountById(Long accountId);

    AccountViewDTO getAccountByNickName(String nickName);

    AccountCreateDTO createAccount(AccountCreateDTO accountCreateDTO);

    AccountUpdateDTO updateAccount(Long accountId, AccountUpdateDTO accountUpdateDTO);

    boolean deleteAccount(Long accountId);
}
