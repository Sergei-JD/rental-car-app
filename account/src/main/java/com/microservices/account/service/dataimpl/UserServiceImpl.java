package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.UserRequestDTO;
import com.microservices.account.dto.UserResponseDTO;
import com.microservices.account.repository.UserRepository;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<UserResponseDTO> getAllUsers(Pageable pageable) {
        return null;
    }

    @Override
    public Page<UserResponseDTO> getAllUsersByRole(String role, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<UserResponseDTO> getUserById(long doctorId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseDTO> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserRequestDTO createUser(UserRequestDTO userDTO) {
        return null;
    }

    @Override
    public UserResponseDTO updateUser(UserResponseDTO userResponseDTO) {
        return null;
    }

    @Override
    public boolean deleteUser(long userId) {
        userRepository.deleteById(userId);

        return userRepository.findById(userId).isEmpty();
    }
}
