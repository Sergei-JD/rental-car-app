package com.microservices.account.service;

import com.microservices.account.dto.UserRequestDTO;
import com.microservices.account.dto.UserResponseFullDTO;
import com.microservices.account.dto.UserResponseViewDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<UserResponseViewDTO> getAllUsers(Pageable pageable);

    Page<UserResponseViewDTO>getAllUsersByRole(String role, Pageable pageable);

    Optional<UserResponseViewDTO> getUserById(long userId);

    Optional<UserResponseFullDTO> getUserByEmail(String email);

    UserRequestDTO createUser(UserRequestDTO userDTO);

    UserResponseFullDTO updateUser(UserResponseFullDTO userResponseFullDTO);

    boolean deleteUser(long userId);
}
