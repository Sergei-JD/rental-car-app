package com.microservices.account.service;

import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getAllUsers(Pageable pageable);

    Page<User> getAllUsersByRole(Role role, Pageable pageable);

    User getUserById(Long userId);

    User getUserByEmail(String email);

    User createUser(User user);

    User updateUser(User user);

    boolean deleteUser(Long userId);
}
