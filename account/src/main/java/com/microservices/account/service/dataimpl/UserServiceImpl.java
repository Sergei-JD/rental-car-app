package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.CreateUserDTO;
import com.microservices.account.dto.update.UpdateUserDTO;
import com.microservices.account.dto.view.ViewUserDTO;
import com.microservices.account.entity.Account;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.exception.ServiceException;
import com.microservices.account.mapper.UserMapper;
import com.microservices.account.repository.AccountRepository;
import com.microservices.account.repository.UserRepository;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.account.util.ServiceData.USER_EMAIL_EXCEPTION_MESSAGE;
import static com.microservices.account.util.ServiceData.USER_ID_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Override
    public Page<ViewUserDTO> getAllUsers(Pageable pageable) {
        Page<User> pageUsers = userRepository.findAll(pageable);

        List<ViewUserDTO> users = pageUsers.stream()
                .map(UserMapper::toViewUserDTO)
                .toList();

        return new PageImpl<>(users);
    }

    @Override
    public Page<ViewUserDTO> getAllUsersByRole(Role role, Pageable pageable) {
        Page<User> pageUsers = userRepository.findAllByRole(role, pageable);

        List<ViewUserDTO> users = pageUsers.stream()
                .map(UserMapper::toViewUserDTO)
                .toList();

        return new PageImpl<>(users);
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
    public Long createUser(CreateUserDTO createUserDTO) {
        Account account = accountRepository.findById(createUserDTO.getAccountId())
                .orElseThrow(() -> new ServiceException("Failed to create 'user'. No such 'account'"));
        User newUser = User.builder()
                .firstName(createUserDTO.getFirstName())
                .lastName(createUserDTO.getLastName())
                .dateOfBirth(createUserDTO.getDateOfBirth())
                .identityPassportNumber(createUserDTO.getIdentityPassportNumber())
                .email(createUserDTO.getEmail())
                .phoneNumber(createUserDTO.getPhoneNumber())
                .gender(createUserDTO.getGender())
                .role(createUserDTO.getRole())
                .account(account)
                .build();

        User savedUser = userRepository.save(newUser);

        return savedUser.getId();
    }

    @Override
    @Transactional
    public void updateUser(Long userId, UpdateUserDTO updateUserDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException(String.format(USER_ID_EXCEPTION_MESSAGE, userId)));
        user.setFirstName(updateUserDTO.getFirstName());
        user.setLastName(updateUserDTO.getLastName());
        user.setDateOfBirth(updateUserDTO.getDateOfBirth());
        user.setIdentityPassportNumber(updateUserDTO.getIdentityPassportNumber());
        user.setEmail(updateUserDTO.getEmail());
        user.setPhoneNumber(updateUserDTO.getPhoneNumber());
        user.setGender(updateUserDTO.getGender());
        user.setRole(updateUserDTO.getRole());

        userRepository.save(user);
    }

    @Override
    @Transactional
    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);

        return userRepository.findById(userId).isEmpty();
    }
}
