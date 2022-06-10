package com.microservices.account.controller;

import com.microservices.account.dto.request.UserRequestDTO;
import com.microservices.account.dto.request.UserUpdateRequestDTO;
import com.microservices.account.dto.response.UserResponseDTO;
import com.microservices.account.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> getAllUsers(Pageable pageable) {
        Page<UserResponseDTO> users = userService.getAllUsers(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/role")
    public ResponseEntity<Page<UserResponseDTO>> getAllUsersByRole(@RequestParam (name = "role") String role, Pageable pageable) {
        Page<UserResponseDTO> users = userService.getAllUsersByRole(role, pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable(name = "id") Long id) {
        Optional<UserResponseDTO> userResponseDTO = userService.getUserById(id);
        return userResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "User with this id: " + id + " does not exist")
                );
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@RequestParam(name = "email") String email) {
        Optional<UserResponseDTO> userResponseDTO = userService.getUserByEmail(email);
        return userResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK))
                .orElseThrow(() -> new RuntimeException(
                        "User with this email: " + email + " does not exist")
                );
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO addUser = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        UserResponseDTO updatedUser = userService.updateUser(userUpdateRequestDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
