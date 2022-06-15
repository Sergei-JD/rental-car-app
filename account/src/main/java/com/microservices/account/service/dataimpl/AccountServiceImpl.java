package com.microservices.account.service.dataimpl;

import com.microservices.account.entity.Account;
import com.microservices.account.repository.AccountRepository;
import com.microservices.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public Optional<Account> getAccountByNickName(String nickName) {
        return accountRepository.findAccountByNickName(nickName);
    }

    @Override
    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account updateAccount(Account account) {
        Account maybeAccount = accountRepository.findById(account.getId())
                .orElseThrow(() -> new ServiceException("Failed to update Account no such Account"));
        return accountRepository.save(maybeAccount);
    }

    @Override
    @Transactional
    public boolean deleteAccount(Long accountId) {
        Optional<Account> maybeAccount = accountRepository.findById(accountId);
        maybeAccount.ifPresent(account -> accountRepository.deleteById(account.getId()));

        return maybeAccount.isPresent();
    }
}
