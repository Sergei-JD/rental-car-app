package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.create.UserCreateDTO;
import com.microservices.account.dto.update.UserUpdateDTO;
import com.microservices.account.dto.view.UserViewDTO;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.exception.ServiceException;
import com.microservices.account.mapper.UserMapper;
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

    @Override
    public Page<UserViewDTO> getAllUsers(Pageable pageable) {
        Page<User> pageUsers = userRepository.findAll(pageable);

        List<UserViewDTO> users = pageUsers.stream()
                .map(UserMapper::toUserViewDTO)
                .toList();

        return new PageImpl<>(users);
    }

    @Override
    public Page<UserViewDTO> getAllUsersByRole(Role role, Pageable pageable) {
        Page<User> pageUsers = userRepository.findAllByRole(role, pageable);

        List<UserViewDTO> users = pageUsers.stream()
                .map(UserMapper::toUserViewDTO)
                .toList();

        return new PageImpl<>(users);
    }

    @Override
    public UserViewDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException(String.format(USER_ID_EXCEPTION_MESSAGE, userId)));

        return UserMapper.toUserViewDTO(user);
    }

    @Override
    public UserViewDTO getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new ServiceException(String.format(USER_EMAIL_EXCEPTION_MESSAGE, email)));

        return UserMapper.toUserViewDTO(user);
    }

    @Override
    @Transactional
    public UserCreateDTO createUser(UserCreateDTO userCreateDTO) {
        User newUser = User.builder()
                .firstName(userCreateDTO.getFirstName())
                .lastName(userCreateDTO.getLastName())
                .dateOfBirth(userCreateDTO.getDateOfBirth())
                .identityPassportNumber(userCreateDTO.getIdentityPassportNumber())
                .email(userCreateDTO.getEmail())
                .phoneNumber(userCreateDTO.getPhoneNumber())
                .gender(userCreateDTO.getGender())
                .role(userCreateDTO.getRole())
                .build();

        return UserMapper.toUserCreateDTO(userRepository.save(newUser));
    }

    @Override
    @Transactional
    public UserUpdateDTO updateUser(Long userId, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException(String.format(USER_ID_EXCEPTION_MESSAGE, userId)));
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setDateOfBirth(userUpdateDTO.getDateOfBirth());
        user.setIdentityPassportNumber(userUpdateDTO.getIdentityPassportNumber());
        user.setEmail(userUpdateDTO.getEmail());
        user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
        user.setGender(userUpdateDTO.getGender());
        user.setRole(userUpdateDTO.getRole());

        userRepository.save(user);

        return UserMapper.toUserUpdateDTO(user);
    }

    @Override
    @Transactional
    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);

        return userRepository.findById(userId).isEmpty();
    }
}
