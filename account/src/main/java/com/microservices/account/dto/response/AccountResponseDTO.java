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

    private Long id;

    private User user;

    private String nickName;

    private String password;

    private String phoneNumber;
}
