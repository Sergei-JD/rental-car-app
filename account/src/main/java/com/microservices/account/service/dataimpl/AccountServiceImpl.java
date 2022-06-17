package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.AccountCreateDTO;
import com.microservices.account.dto.update.AccountUpdateDTO;
import com.microservices.account.dto.view.AccountViewDTO;
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
    public Page<AccountViewDTO> getAllAccounts(Pageable pageable) {
        Page<Account> pageAccounts = accountRepository.findAll(pageable);

        List<AccountViewDTO> accounts = pageAccounts.stream()
                .map(AccountMapper::toAccountViewDTO)
                .toList();

        return new PageImpl<>(accounts);
    }

    @Override
    public AccountViewDTO getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ServiceException(String.format(ACCOUNT_ID_EXCEPTION_MESSAGE, accountId)));

        return AccountMapper.toAccountViewDTO(account);
    }

    @Override
    public AccountViewDTO getAccountByNickName(String nickName) {
        Account account = accountRepository.findAccountByNickName(nickName)
                .orElseThrow(() -> new ServiceException(String.format(ACCOUNT_NICKNAME_EXCEPTION_MESSAGE, nickName)));

        return AccountMapper.toAccountViewDTO(account);
    }

    @Override
    @Transactional
    public AccountCreateDTO createAccount(AccountCreateDTO accountCreateDTO) {
        Account newAccount = Account.builder()
                .nickName(accountCreateDTO.getNickName())
                .password(accountCreateDTO.getPassword())
                .build();

        return AccountMapper.toAccountCreateDTO(accountRepository.save(newAccount));
    }

    @Override
    @Transactional
    public AccountUpdateDTO updateAccount(Long accountId, AccountUpdateDTO accountUpdateDTO) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ServiceException(String.format(ACCOUNT_ID_EXCEPTION_MESSAGE, accountId)));
        account.setNickName(accountUpdateDTO.getNickName());
        account.setPassword(accountUpdateDTO.getPassword());

        accountRepository.save(account);

        return AccountMapper.toAccountUpdateDTO(account);
    }

    @Override
    @Transactional
    public boolean deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);

        return accountRepository.findById(accountId).isEmpty();
    }
}
