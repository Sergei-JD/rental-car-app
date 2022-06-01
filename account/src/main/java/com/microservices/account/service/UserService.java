package com.microservices.account.service;

import com.microservices.account.dto.UserRequestDTO;
import com.microservices.account.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<UserResponseDTO> getAllUsers(Pageable pageable);

    Page<UserResponseDTO>getAllUsersByRole(String role, Pageable pageable);

    Optional<UserResponseDTO> getUserById(long userId);

    Optional<UserResponseDTO> getUserByEmail(String email);

    UserRequestDTO createUser(UserRequestDTO userDTO);

    UserResponseDTO updateUser(UserResponseDTO userResponseDTO);

    boolean deleteUser(long userId);
}
