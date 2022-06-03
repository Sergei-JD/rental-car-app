package com.microservices.account.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.account.entity.User;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {

    @NotEmpty(message = "'User id' should not be empty")
    @Positive(message = "'User id' should be positive number")
    private User userId;

    @NotEmpty(message = "'Nick name' name should not be empty")
    @Size(min = 2, max = 256, message = "'Nick name' should be between 2 and 256 characters")
    private String nickName;

    @JsonProperty("password")
    @NotEmpty(message = "'Password' should not be empty")
    @Size(min = 2, max = 256, message = "'Password' should be between 2 and 256 characters")
    private String password;

    @NotEmpty(message = "'Phone number' should not be empty")
    @Size(min = 13, max = 13, message = "'Phone number' should have 13 characters")
    private String phoneNumber;
}
