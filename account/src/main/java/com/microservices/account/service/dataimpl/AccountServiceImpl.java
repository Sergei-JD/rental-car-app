package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.CreateAccountDTO;
import com.microservices.account.dto.update.UpdateAccountDTO;
import com.microservices.account.dto.view.ViewAccountDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.mapper.AccountMapper;
import com.microservices.account.repository.AccountRepository;
import com.microservices.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.account.util.ServiceData.ACCOUNT_ID_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.ACCOUNT_NICKNAME_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Page<ViewAccountDTO> getAllAccounts(Pageable pageable) {
        Page<Account> pageAccounts = accountRepository.findAll(pageable);

        List<ViewAccountDTO> accounts = pageAccounts.stream()
                .map(AccountMapper::toViewAccountDTO)
                .toList();

        return new PageImpl<>(accounts);
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
    public Long createAccount(CreateAccountDTO createAccountDTO) {
        Account newAccount = Account.builder()
                .nickName(createAccountDTO.getNickName())
                .password(createAccountDTO.getPassword())
                .build();

        Account savedAccount = accountRepository.save(newAccount);

        return savedAccount.getId();
    }

    @Override
    @Transactional
    public void updateAccount(Long accountId, UpdateAccountDTO updateAccountDTO) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ServiceException(String.format(ACCOUNT_ID_EXCEPTION_MESSAGE, accountId)));
        account.setNickName(updateAccountDTO.getNickName());
        account.setPassword(updateAccountDTO.getPassword());

        accountRepository.save(account);
    }

    @Override
    @Transactional
    public boolean deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);

        return accountRepository.findById(accountId).isEmpty();
    }
}
