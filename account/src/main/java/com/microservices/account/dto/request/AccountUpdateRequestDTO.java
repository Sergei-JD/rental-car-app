package com.microservices.account.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateRequestDTO {

    @NotEmpty(message = "'Account id' should not be empty")
    @Positive(message = "'Account id' should be positive number")
    private Long id;

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
