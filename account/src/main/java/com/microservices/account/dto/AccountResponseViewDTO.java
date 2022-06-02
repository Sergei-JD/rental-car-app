package com.microservices.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseViewDTO {

    @Positive(message = "Account id should be positive number")
    private Long accountId;

    @NotEmpty(message = "Nick name name should not be empty")
    @Size(min = 2, max = 256, message = "Nick name should be between 2 and 256 characters")
    private String nickName;
}
