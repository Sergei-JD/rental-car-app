package com.microservices.account.service;

import com.microservices.account.dto.create.UserCreateDTO;
import com.microservices.account.dto.update.UserUpdateDTO;
import com.microservices.account.dto.view.UserViewDTO;
import com.microservices.account.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserViewDTO> getAllUsers(Pageable pageable);

    Page<UserViewDTO> getAllUsersByRole(Role role, Pageable pageable);

    UserViewDTO getUserById(Long userId);

    UserViewDTO getUserByEmail(String email);

    UserCreateDTO createUser(UserCreateDTO userCreateDTO);

    UserUpdateDTO updateUser(Long userId, UserUpdateDTO userUpdateDTO);

    boolean deleteUser(Long userId);
}
