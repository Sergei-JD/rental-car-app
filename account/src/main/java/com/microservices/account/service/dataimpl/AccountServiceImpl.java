package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.AccountRequestDTO;
import com.microservices.account.dto.request.AccountUpdateRequestDTO;
import com.microservices.account.dto.response.AccountResponseDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.mapper.request.AccountRequestDTOToAccountMapper;
import com.microservices.account.mapper.request.AccountUpdateRequestDTOToAccountMapper;
import com.microservices.account.mapper.response.AccountToAccountResponseDTOMapper;
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
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountRequestDTOToAccountMapper accountRequestDTOToAccountMapper;
    private final AccountToAccountResponseDTOMapper accountToAccountResponseDTOMapper;
    private final AccountUpdateRequestDTOToAccountMapper accountUpdateRequestDTOToAccountMapper;

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
        Account saveAccount = accountRepository.save(Objects.requireNonNull(newAccount));

        return accountToAccountResponseDTOMapper.convert(saveAccount);
    }

    @Override
    @Transactional
    public AccountResponseDTO updateAccount(AccountUpdateRequestDTO accountUpdateRequestDTO) {
        accountRepository.findById(accountUpdateRequestDTO.getAccountId())
                .orElseThrow(() -> new ServiceException("Failed to update account no such account"));

        Account account = accountUpdateRequestDTOToAccountMapper.convert(accountUpdateRequestDTO);
        Account updateAccount = accountRepository.save(Objects.requireNonNull(account));

        return accountToAccountResponseDTOMapper.convert(updateAccount);
    }

    @Override
    @Transactional
    public boolean deleteAccount(long accountId) {
        accountRepository.deleteById(accountId);

        return accountRepository.findById(accountId).isEmpty();
    }
}
