package com.microservices.account.dto.view;

import com.microservices.account.entity.Gender;
import com.microservices.account.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ViewUserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Instant dateOfBirth;

    private String identityPassportNumber;

    private String email;

    private String phoneNumber;

    private Gender gender;

    private Role role;

//    private Account accountId;
}
