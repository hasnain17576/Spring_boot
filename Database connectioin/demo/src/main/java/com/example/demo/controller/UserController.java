package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.UserDTO;

import jakarta.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE
    @PostMapping("/user")
    public User addUser(@Valid @RequestBody UserDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return userService.saveUser(user);
    }

    // READ ALL
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // PROFILE
    @GetMapping("/profile")
    public User profile(Authentication authentication) {
        return userService.findByUsername(authentication.getName()).orElse(null);
    }

    // ADMIN endpoint (ROLE_ADMIN guards via SecurityConfig)
    @GetMapping("/admin/users")
    public List<User> getUsersAdmin() {
        return userService.getAllUsers();
    }

    // READ BY ID
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // UPDATE
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted";
    }
}