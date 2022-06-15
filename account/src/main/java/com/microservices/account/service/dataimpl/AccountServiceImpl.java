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

import static com.microservices.account.util.ServiceData.ACCOUNT_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.ACCOUNT_ID_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.ACCOUNT_NICKNAME_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.ACCOUNT_UPDATE_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ServiceException(String.format(ACCOUNT_ID_EXCEPTION_MESSAGE, accountId)));
    }

    @Override
    public Account getAccountByNickName(String nickName) {
        return accountRepository.findAccountByNickName(nickName)
                .orElseThrow(() -> new ServiceException(String.format(ACCOUNT_NICKNAME_EXCEPTION_MESSAGE, nickName)));
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
                .orElseThrow(() -> new ServiceException(ACCOUNT_UPDATE_EXCEPTION_MESSAGE));
        return accountRepository.save(maybeAccount);
    }

    @Override
    @Transactional
    public boolean deleteAccount(Long accountId) {
        Account maybeAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new ServiceException(String.format(ACCOUNT_DELETE_EXCEPTION_MESSAGE, accountId)));
        accountRepository.deleteById(maybeAccount.getId());
        return accountRepository.findById(accountId).isEmpty();
    }
}
