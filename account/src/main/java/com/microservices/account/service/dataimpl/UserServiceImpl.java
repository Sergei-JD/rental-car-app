package com.microservices.account.service.dataimpl;

import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.repository.UserRepository;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> getAllUsersByRole(Role role, Pageable pageable) {
        return userRepository.findAllByRole(role, pageable);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        User maybeUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new ServiceException("Failed to update User no such User"));
        return userRepository.save(maybeUser);
    }

    @Override
    @Transactional
    public boolean deleteUser(Long userId) {
        Optional<User> maybeUser = userRepository.findById(userId);
        maybeUser.ifPresent(user -> userRepository.deleteById(user.getId()));

        return maybeUser.isPresent();
    }
}
