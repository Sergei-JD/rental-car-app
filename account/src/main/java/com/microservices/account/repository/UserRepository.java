package com.microservices.account.repository;

import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    List<User> findAllByRole(Role role);

}
