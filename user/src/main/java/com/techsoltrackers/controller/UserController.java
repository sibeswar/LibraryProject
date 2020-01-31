package com.techsoltrackers.controller;

import com.techsoltrackers.domain.dto.User;
import com.techsoltrackers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    // Update a user
    @PostMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody User userDetails) {

        return ResponseEntity.ok().body(userService.updateUser(userId,userDetails));
    }

    // Delete a User
    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long userId) {
        userService.deleteUser(userId);
        return (ResponseEntity) ResponseEntity.ok();
    }
}
