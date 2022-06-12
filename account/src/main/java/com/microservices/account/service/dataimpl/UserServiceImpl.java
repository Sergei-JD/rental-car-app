package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.UserRequestDTO;
import com.microservices.account.dto.request.UserUpdateRequestDTO;
import com.microservices.account.dto.response.UserResponseDTO;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.mapper.request.UserRequestDTOToUserMapper;
import com.microservices.account.mapper.request.UserUpdateRequestDTOToUserMapper;
import com.microservices.account.mapper.response.UserToUserResponseDTOMapper;
import com.microservices.account.repository.UserRepository;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRequestDTOToUserMapper userRequestDTOToUserMapper;
    private final UserToUserResponseDTOMapper userToUserResponseDTOMapper;
    private final UserUpdateRequestDTOToUserMapper userUpdateRequestDTOToUserMapper;

    @Override
    public Page<UserResponseDTO> getAllUsers(Pageable pageable) {
        Page<User> pageUsers = userRepository.findAll(pageable);

        List<UserResponseDTO> users = pageUsers.stream()
                .map(userToUserResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(users);
    }

    @Override
    public Page<UserResponseDTO> getAllUsersByRole(Role role, Pageable pageable) {
        Page<User> pageUsers = userRepository.findAllByRole(role, pageable);

        List<UserResponseDTO> users = pageUsers.stream()
                .map(userToUserResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(users);
    }

    @Override
    public Optional<UserResponseDTO> getUserById(Long userId) {
        UserResponseDTO userResponseDTO = null;

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userResponseDTO = userToUserResponseDTOMapper.convert(user.get());
        }

        return Optional.ofNullable(userResponseDTO);
    }

    @Override
    public Optional<UserResponseDTO> getUserByEmail(String email) {
        UserResponseDTO userResponseDTO = null;

        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isPresent()) {
            userResponseDTO = userToUserResponseDTOMapper.convert(user.get());
        }

        return Optional.ofNullable(userResponseDTO);
    }

    @Override
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User newUser = userRequestDTOToUserMapper.convert(userRequestDTO);
        User saveUser = userRepository.save(Objects.requireNonNull(newUser));

        return userToUserResponseDTOMapper.convert(saveUser);
    }


    @Override
    @Transactional
    public UserResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        userRepository.findById(userUpdateRequestDTO.getId())
                .orElseThrow(() -> new ServiceException("Failed to update user no such user"));

        User user = userUpdateRequestDTOToUserMapper.convert(userUpdateRequestDTO);
        User updateUser = userRepository.save(Objects.requireNonNull(user));

        return userToUserResponseDTOMapper.convert(updateUser);
    }

    @Override
    @Transactional
    public boolean deleteUser(Long userId) {
        Optional<User> maybeUser = userRepository.findById(userId);
        maybeUser.ifPresent(user -> userRepository.deleteById(user.getId()));

        return maybeUser.isPresent();
    }
}
