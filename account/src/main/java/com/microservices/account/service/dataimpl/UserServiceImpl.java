package com.microservices.account.service.dataimpl;

import com.microservices.account.dto.UserRequestDTO;
import com.microservices.account.dto.UserResponseFullDTO;
import com.microservices.account.dto.UserResponseViewDTO;
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
    public Page<UserResponseViewDTO> getAllUsers(Pageable pageable) {
        return null;
    }

    @Override
    public Page<UserResponseViewDTO> getAllUsersByRole(String role, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<UserResponseViewDTO> getUserById(long doctorId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserResponseFullDTO> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public UserRequestDTO createUser(UserRequestDTO userDTO) {
        return null;
    }

    @Override
    public UserResponseFullDTO updateUser(UserResponseFullDTO userResponseFullDTO) {
        return null;
    }

    @Override
    public boolean deleteUser(long userId) {
        userRepository.deleteById(userId);

        return userRepository.findById(userId).isEmpty();
    }
}
