package com.microservices.account.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.account.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDTO {

    @NotEmpty(message = "'User id' should not be empty")
    @Positive(message = "'User id' should be positive number")
    private Long id;

    @NotEmpty(message = "'First name' should not be empty")
    @Size(min = 2, max = 256, message = "'First name' should be between 2 and 256 characters")
    private String firstName;

    @NotEmpty(message = "'Last name' should not be empty")
    @Size(min = 2, max = 256, message = "'Last name' should be between 2 and 256 characters")
    private String lastName;

    @NotEmpty(message = "'Passport' number should not be empty")
    @Size(min = 14, max = 14, message = "'Passport' number should have 14 characters")
    private String identityPassportNumber;

    @NotEmpty(message = "'Email' should not be empty")
    @Email(message = "'Email' should be valid")
    private String email;

    @JsonProperty("password")
    @NotEmpty(message = "'Password' should not be empty")
    @Size(min = 2, max = 256, message = "'Password' should be between 2 and 256 characters")
    private String password;

    @NotEmpty(message = "'Gender' should not be empty")
    @Size(min = 2, max = 64, message = "'Gender' should be 'MALE' or 'FEMALE'")
    private Gender gender;
}
