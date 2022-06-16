package com.microservices.account.controller;

import com.microservices.account.dto.request.UpdateUserDTO;
import com.microservices.account.dto.request.UserRequestDTO;
import com.microservices.account.dto.response.UserResponseDTO;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.mapper.request.UpdateUserDTOToUserMapper;
import com.microservices.account.mapper.request.UserRequestDTOToUserMapper;
import com.microservices.account.mapper.response.UserToUserResponseDTOMapper;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;
    private final UserRequestDTOToUserMapper userRequestDTOToUserMapper;
    private final UserToUserResponseDTOMapper userToUserResponseDTOMapper;
    private final UpdateUserDTOToUserMapper updateUserDTOToUserMapper;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(Pageable pageable) {
        List<UserResponseDTO> users = userService.getAllUsers(pageable).stream()
                .map(userToUserResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/role")
    public ResponseEntity<List<UserResponseDTO>> getAllUsersByRole(@RequestParam(name = "role") Role role, Pageable pageable) {
        List<UserResponseDTO> users = userService.getAllUsersByRole(role, pageable).stream()
                .map(userToUserResponseDTOMapper::convert)
                .toList();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        UserResponseDTO userResponseDTO = userToUserResponseDTOMapper.convert(user);

        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@RequestParam(name = "email") String email) {
        User user = userService.getUserByEmail(email);
        UserResponseDTO userResponseDTO = userToUserResponseDTOMapper.convert(user);

        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        User user = userRequestDTOToUserMapper.convert(userRequestDTO);
        User createdUser = userService.createUser(user);
        UserResponseDTO addUser = userToUserResponseDTOMapper.convert(createdUser);

        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody @Valid UpdateUserDTO updateUserDTO) {
        User user = updateUserDTOToUserMapper.convert(updateUserDTO);
        User updateUser = userService.updateUser(user);
        UserResponseDTO updatedUser = userToUserResponseDTOMapper.convert(updateUser);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "id") Long id) {
        boolean deleteUser = userService.deleteUser(id);

        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
}
