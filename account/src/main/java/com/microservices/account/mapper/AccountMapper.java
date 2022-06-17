package com.microservices.account.mapper;

import com.microservices.account.dto.create.AccountCreateDTO;
import com.microservices.account.dto.update.AccountUpdateDTO;
import com.microservices.account.dto.view.AccountViewDTO;
import com.microservices.account.entity.Account;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountMapper {

    public static AccountViewDTO toAccountViewDTO(Account account) {
        return Optional.ofNullable(account)
                .map(existAccount -> AccountViewDTO.builder()
                        .id(account.getId())
                        .nickName(account.getNickName())
                        .password(account.getPassword())
                        .build())
                .orElse(null);
    }

    public static AccountCreateDTO toAccountCreateDTO(Account account) {
        return Optional.ofNullable(account)
                .map(existAccount -> AccountCreateDTO.builder()
                        .nickName(account.getNickName())
                        .password(account.getPassword())
                        .build())
                .orElse(null);
    }

    public static AccountUpdateDTO toAccountUpdateDTO(Account account) {
        return Optional.ofNullable(account)
                .map(existAccount -> AccountUpdateDTO.builder()
                        .nickName(account.getNickName())
                        .password(account.getPassword())
                        .build())
                .orElse(null);
    }
}
