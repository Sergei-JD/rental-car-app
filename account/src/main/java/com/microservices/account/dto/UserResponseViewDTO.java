package com.microservices.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseViewDTO {

    @Positive(message = "'User id' should be positive number")
    private Long userId;

    @NotEmpty(message = "'First name' should not be empty")
    @Size(min = 2, max = 256, message = "'First name' should be between 2 and 256 characters")
    private String firstName;

    @NotEmpty(message = "'Last name' should not be empty")
    @Size(min = 2, max = 256, message = "'Last name' should be between 2 and 256 characters")
    private String lastName;

}
