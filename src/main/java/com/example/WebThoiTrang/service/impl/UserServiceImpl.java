package com.example.WebThoiTrang.service.impl;

import com.example.WebThoiTrang.model.User;
import com.example.WebThoiTrang.modelDTO.UserDTO;
import com.example.WebThoiTrang.repository.UserRepository;
import com.example.WebThoiTrang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    // Helper: Chuyển Entity -> DTO
    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setFullName(user.getFullName());
        dto.setAddress(user.getAddress());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    // Helper: Chuyển DTO -> Entity
    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullName());
        user.setAddress(dto.getAddress());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        user.setCreatedAt(dto.getCreatedAt());
        return user;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user.setCreatedAt(LocalDateTime.now());
        return convertToDTO(userRepository.save(user));
    }



    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        return userRepository.findById(id).map( u -> convertToDTO(u));

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(u -> convertToDTO(u)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        return userRepository.findById(id).map(existingUser ->{
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPassword(userDTO.getPassword());
            existingUser.setFullName(userDTO.getFullName());
            existingUser.setAddress(userDTO.getAddress());
            existingUser.setPhone(userDTO.getPhone());
            existingUser.setRole(userDTO.getRole());
            return convertToDTO(userRepository.save(existingUser));
        }).orElseThrow(() -> new RuntimeException("User not found with id" + id));
    }

    @Override
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> findByUsernameContainingIgnoreCase(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByEmailContainingIgnoreCase(String email) {
        return userRepository.findByEmailContainingIgnoreCase(email)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByFullNameContainingIgnoreCase(String fullName) {
        return userRepository.findByFullNameContainingIgnoreCase(fullName)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> searchUsersByKeyword(String keyword) {
        return userRepository.searchUsersByKeyword(keyword)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
