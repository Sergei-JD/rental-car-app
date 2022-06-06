package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.request.UserRequestDTO;
import com.microservices.account.dto.response.UserResponseDTO;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.mapper.request.UserRequestDTOToUserMapper;
import com.microservices.account.mapper.response.UserToUserResponseDTOMapper;
import com.microservices.account.repository.UserRepository;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRequestDTOToUserMapper userRequestDTOToUserMapper;
    private final UserToUserResponseDTOMapper userToUserResponseDTOMapper;

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
    public Optional<UserResponseDTO> getUserById(long userId) {
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

        return userToUserResponseDTOMapper.convert(userRepository.save(newUser));
    }


    @Override
    @Transactional
    public UserResponseDTO updateUser(Long userId, UserRequestDTO userRequestDTO) {
        User user = userRequestDTOToUserMapper.convert(userRequestDTO);
        user.setUserId(userId);

        return userToUserResponseDTOMapper.convert(userRepository.save(user));
    }

    @Override
    @Transactional
    public boolean deleteUser(long userId) {
        userRepository.deleteById(userId);

        return userRepository.findById(userId).isEmpty();
    }
}
