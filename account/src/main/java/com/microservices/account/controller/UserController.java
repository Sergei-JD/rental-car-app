package com.microservices.account.controller;

import com.microservices.account.dto.create.CreateUserDTO;
import com.microservices.account.dto.update.UpdateUserDTO;
import com.microservices.account.dto.view.ViewUserDTO;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import com.microservices.account.mapper.UserMapper;
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
    public ResponseEntity<Page<ViewUserDTO>> getAllUsers(Pageable pageable) {
        Page<ViewUserDTO> users = userService.getAllUsers(pageable);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/role")
    public ResponseEntity<Page<ViewUserDTO>> getAllUsersByRole(
            @RequestParam(name = "role") Role role, Pageable pageable) {
        Page<ViewUserDTO> users = userService.getAllUsersByRole(role, pageable);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewUserDTO> getUserById(
            @PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        ViewUserDTO viewUserDTO = UserMapper.toUserViewDTO(user);

        return new ResponseEntity<>(viewUserDTO, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<ViewUserDTO> getUserByEmail(
            @RequestParam(name = "email") String email) {
        User user = userService.getUserByEmail(email);
        ViewUserDTO viewUserDTO = UserMapper.toUserViewDTO(user);

        return new ResponseEntity<>(viewUserDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createUser(
            @RequestBody @Valid CreateUserDTO createUserDTO) {
        Long addUser = userService.createUser(createUserDTO);

        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateUserDTO updateUserDTO) {
        userService.updateUser(id, updateUserDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(
            @PathVariable(name = "id") Long id) {
        boolean deleteUser = userService.deleteUser(id);

        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }
}
