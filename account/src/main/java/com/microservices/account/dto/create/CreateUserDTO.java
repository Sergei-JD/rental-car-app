package com.microservices.account.dto.create;

import com.microservices.account.entity.Account;
import com.microservices.account.entity.Gender;
import com.microservices.account.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Persistable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {

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

    @NotEmpty(message = "'Phone number' should not be empty")
    @Size(min = 13, max = 13, message = "'Phone number' should have 13 characters")
    private String phoneNumber;

    @NotEmpty(message = "'Gender' should not be empty")
    @Size(min = 2, max = 64, message = "'Gender' should be 'MALE' or 'FEMALE'")
    private Gender gender;

    @NotEmpty(message = "'Role' should not be empty")
    @Size(min = 2, max = 64, message = "'Role' should be 'ADMIN' or 'CUSTOMER' or 'MECHANIC'")
    private Role role;

    @NotEmpty(message = "'Account id' should not be empty")
    private Long accountId;
}
