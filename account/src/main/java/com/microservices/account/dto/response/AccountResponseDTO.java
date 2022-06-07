package com.microservices.account.dto.response;

import com.microservices.account.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {

    private Long accountId;

    private User userId;

    private String nickName;

    private String password;

    private String phoneNumber;
}