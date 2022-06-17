package com.microservices.account.mapper;

import com.microservices.account.dto.create.UserCreateDTO;
import com.microservices.account.dto.update.UserUpdateDTO;
import com.microservices.account.dto.view.UserViewDTO;
import com.microservices.account.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserViewDTO toUserViewDTO(User user) {
        return Optional.ofNullable(user)
                .map(existUser -> UserViewDTO.builder()
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

    public static UserCreateDTO toUserCreateDTO(User user) {
        return Optional.ofNullable(user)
                .map(existUser -> UserCreateDTO.builder()
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

    public static UserUpdateDTO toUserUpdateDTO(User user) {
        return Optional.ofNullable(user)
                .map(existUser -> UserUpdateDTO.builder()
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
