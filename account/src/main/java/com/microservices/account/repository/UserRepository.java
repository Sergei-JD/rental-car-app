package com.microservices.account.repository;

import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    Page<User> findAllByRole(Role role, Pageable pageable);

}
