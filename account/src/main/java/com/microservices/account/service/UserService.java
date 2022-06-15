package com.microservices.account.service;

import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<User> getAllUsers(Pageable pageable);

    Page<User> getAllUsersByRole(Role role, Pageable pageable);

    Optional<User> getUserById(Long userId);

    Optional<User> getUserByEmail(String email);

    User createUser(User user);

    User updateUser(User user);

    boolean deleteUser(Long userId);
}
