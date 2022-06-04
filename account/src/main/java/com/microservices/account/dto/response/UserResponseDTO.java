package com.microservices.account.dto.response;

import com.microservices.account.entity.Role;
import com.microservices.account.entity.Gender;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private Long userId;

    private String firstName;

    private String lastName;

    private Instant dateOfBirth;

    private String identityPassportNumber;

    private String email;

    private String password;

    private Gender gender;

    private Role role;
}
