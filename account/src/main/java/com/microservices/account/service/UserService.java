package com.microservices.account.service;

import com.microservices.account.dto.create.CreateUserDTO;
import com.microservices.account.dto.update.UpdateUserDTO;
import com.microservices.account.dto.view.ViewUserDTO;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<ViewUserDTO> getAllUsers(Pageable pageable);

    Page<ViewUserDTO> getAllUsersByRole(Role role, Pageable pageable);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    Long createUser(CreateUserDTO createUserDTO);

    void updateUser(Long userId, UpdateUserDTO updateUserDTO);

    boolean deleteUser(Long userId);
}
