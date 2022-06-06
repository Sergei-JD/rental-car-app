package com.microservices.account.service;

import com.microservices.account.dto.request.UserRequestDTO;
import com.microservices.account.dto.response.UserResponseDTO;
import com.microservices.account.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<UserResponseDTO> getAllUsers(Pageable pageable);

    Page<UserResponseDTO>getAllUsersByRole(Role role, Pageable pageable);

    Optional<UserResponseDTO> getUserById(long userId);

    Optional<UserResponseDTO> getUserByEmail(String email);

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO);

    boolean deleteUser(long userId);
}
