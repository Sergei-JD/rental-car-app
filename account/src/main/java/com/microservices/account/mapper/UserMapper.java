package com.microservices.account.mapper;

import com.microservices.account.dto.create.CreateUserDTO;
import com.microservices.account.dto.update.UpdateUserDTO;
import com.microservices.account.dto.view.ViewUserDTO;
import com.microservices.account.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static ViewUserDTO toViewUserDTO(User user) {
        return Optional.ofNullable(user)
                .map(existUser -> ViewUserDTO.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .dateOfBirth(user.getDateOfBirth())
                        .identityPassportNumber(user.getIdentityPassportNumber())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .gender(user.getGender())
                        .role(user.getRole())
                        .build())
                .orElse(null);
    }

    public static CreateUserDTO toCreateUserDTO(User user) {
        return Optional.ofNullable(user)
                .map(existUser -> CreateUserDTO.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .dateOfBirth(user.getDateOfBirth())
                        .identityPassportNumber(user.getIdentityPassportNumber())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .gender(user.getGender())
                        .role(user.getRole())
                        .build())
                .orElse(null);
    }

    public static UpdateUserDTO toUpdateUserDTO(User user) {
        return Optional.ofNullable(user)
                .map(existUser -> UpdateUserDTO.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .dateOfBirth(user.getDateOfBirth())
                        .identityPassportNumber(user.getIdentityPassportNumber())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .gender(user.getGender())
                        .role(user.getRole())
                        .build())
                .orElse(null);
    }
}
