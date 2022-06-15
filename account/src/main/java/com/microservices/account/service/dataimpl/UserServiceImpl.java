package com.microservices.account.service.dataimpl;

import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.exception.ServiceException;
import com.microservices.account.repository.UserRepository;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.microservices.account.util.ServiceData.USER_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.USER_EMAIL_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.USER_ID_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.USER_UPDATE_EXCEPTION_MESSAGE;

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
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException(String.format(USER_ID_EXCEPTION_MESSAGE, userId)));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new ServiceException(String.format(USER_EMAIL_EXCEPTION_MESSAGE, email)));
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
                .orElseThrow(() -> new ServiceException(USER_UPDATE_EXCEPTION_MESSAGE));
        return userRepository.save(maybeUser);
    }

    @Override
    @Transactional
    public boolean deleteUser(Long userId) {
        User maybeUser = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException(String.format(USER_DELETE_EXCEPTION_MESSAGE, userId)));
        userRepository.deleteById(maybeUser.getId());
        return userRepository.findById(userId).isEmpty();
    }
}
