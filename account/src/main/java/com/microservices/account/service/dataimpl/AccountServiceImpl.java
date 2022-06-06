package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.AccountRequestDTO;
import com.microservices.account.dto.response.AccountResponseDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.mapper.request.AccountRequestDTOToAccountMapper;
import com.microservices.account.mapper.response.AccountToAccountResponseDTOMapper;
import com.microservices.account.repository.AccountRepository;
import com.microservices.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountRequestDTOToAccountMapper accountRequestDTOToAccountMapper;
    private final AccountToAccountResponseDTOMapper accountToAccountResponseDTOMapper;

    @Override
    public Page<AccountResponseDTO> getAllAccounts(Pageable pageable) {
        Page<Account> pageAccounts = accountRepository.findAll(pageable);

        List<AccountResponseDTO> accounts = pageAccounts.stream()
                .map(accountToAccountResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(accounts);
    }

    @Override
    public Optional<AccountResponseDTO> getAccountById(long accountId) {
        AccountResponseDTO accountResponseDTO = null;

        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            accountResponseDTO = accountToAccountResponseDTOMapper.convert(account.get());
        }

        return Optional.ofNullable(accountResponseDTO);
    }

    @Override
    public Optional<AccountResponseDTO> getAccountByNickName(String nickName) {
        AccountResponseDTO accountResponseDTO = null;

        Optional<Account> account = accountRepository.findAccountByNickName(nickName);
        if (account.isPresent()) {
            accountResponseDTO = accountToAccountResponseDTOMapper.convert(account.get());
        }

        return Optional.ofNullable(accountResponseDTO);
    }

    @Override
    @Transactional
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {
        Account newAccount = accountRequestDTOToAccountMapper.convert(accountRequestDTO);

        return accountToAccountResponseDTOMapper.convert(accountRepository.save(newAccount));
    }

    @Override
    @Transactional
    public AccountResponseDTO updateAccount(Long accountId, AccountRequestDTO accountRequestDTO) {
        Account account = accountRequestDTOToAccountMapper.convert(accountRequestDTO);
        account.setAccountId(accountId);

        return accountToAccountResponseDTOMapper.convert(accountRepository.save(account));
    }

    @Override
    @Transactional
    public boolean deleteAccount(long accountId) {
        accountRepository.deleteById(accountId);

        return accountRepository.findById(accountId).isEmpty();
    }
}
