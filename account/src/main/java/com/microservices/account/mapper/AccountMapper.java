package com.microservices.account.mapper;

import com.microservices.account.dto.view.ViewAccountDTO;
import com.microservices.account.entity.Account;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountMapper {

    public static ViewAccountDTO toViewAccountDTO(Account account) {
        return Optional.ofNullable(account)
                .map(existAccount -> ViewAccountDTO.builder()
                        .id(account.getId())
                        .nickName(account.getNickName())
                        .password(account.getPassword())
                        .build())
                .orElse(null);
    }
}
