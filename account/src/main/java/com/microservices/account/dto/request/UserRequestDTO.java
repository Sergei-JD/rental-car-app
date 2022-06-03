package com.microservices.account.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.Gender;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotEmpty(message = "'First name' should not be empty")
    @Size(min = 2, max = 256, message = "'First name' should be between 2 and 256 characters")
    private String firstName;

    @NotEmpty(message = "'Last name' should not be empty")
    @Size(min = 2, max = 256, message = "'Last name' should be between 2 and 256 characters")
    private String lastName;

    @NotEmpty(message = "'Date of birth' should not be empty")
    @Past(message = "'Date of birth' should be before current")
    private Instant dateOfBirth;

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

    @NotEmpty(message = "'Role' should not be empty")
    @Size(min = 2, max = 64, message = "'Role' should be 'ADMIN' or 'CUSTOMER' or 'MECHANIC'")
    private Role role;
}
