package com.microservices.account.controller;

import com.microservices.account.dto.create.UserCreateDTO;
import com.microservices.account.dto.update.UserUpdateDTO;
import com.microservices.account.dto.view.UserViewDTO;
import com.microservices.account.entity.Role;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserViewDTO>> getAllUsers(Pageable pageable) {
        Page<UserViewDTO> users = userService.getAllUsers(pageable);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/role")
    public ResponseEntity<Page<UserViewDTO>> getAllUsersByRole(@RequestParam(name = "role") Role role, Pageable pageable) {
        Page<UserViewDTO> users = userService.getAllUsersByRole(role, pageable);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable(name = "id") Long id) {
        UserViewDTO userViewDTO = userService.getUserById(id);

        return new ResponseEntity<>(userViewDTO, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<UserViewDTO> getUserByEmail(@RequestParam(name = "email") String email) {
        UserViewDTO userViewDTO = userService.getUserByEmail(email);

        return new ResponseEntity<>(userViewDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserCreateDTO> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {
        UserCreateDTO addUser = userService.createUser(userCreateDTO);

        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable(name = "id") Long id, @RequestBody @Valid UserUpdateDTO userUpdateDTO) {
        UserUpdateDTO updateUser = userService.updateUser(id, userUpdateDTO);

        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "id") Long id) {
        boolean deleteUser = userService.deleteUser(id);

        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
}
