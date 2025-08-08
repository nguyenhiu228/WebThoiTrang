package com.example.WebThoiTrang.controller;

import com.example.WebThoiTrang.modelDTO.UserDTO;
import com.example.WebThoiTrang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") //
public class UserController {
    @Autowired
    private UserService userService;

    // CREATE
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // READ - Get all users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // READ - Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // SEARCH - Username
    @GetMapping("/search/username")
    public ResponseEntity<List<UserDTO>> searchByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userService.findByUsernameContainingIgnoreCase(username));
    }

    // SEARCH - Email
    @GetMapping("/search/email")
    public ResponseEntity<List<UserDTO>> searchByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findByEmailContainingIgnoreCase(email));
    }

    // SEARCH - Full name
    @GetMapping("/search/fullname")
    public ResponseEntity<List<UserDTO>> searchByFullName(@RequestParam String fullname) {
        return ResponseEntity.ok(userService.findByFullNameContainingIgnoreCase(fullname));
    }

    // SEARCH - Keyword
    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> searchByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok(userService.searchUsersByKeyword(keyword));
    }

    // CHECK tồn tại username
    @GetMapping("/exists/username")
    public ResponseEntity<Boolean> existsByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userService.existsByUsername(username));
    }

    // CHECK tồn tại email
    @GetMapping("/exists/email")
    public ResponseEntity<Boolean> existsByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.existsByEmail(email));
    }
}
