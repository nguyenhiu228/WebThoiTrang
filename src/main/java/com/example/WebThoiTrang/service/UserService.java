package com.example.WebThoiTrang.service;
import com.example.WebThoiTrang.modelDTO.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // CREATE
    UserDTO createUser(UserDTO userDTO);

    // READ
    Optional<UserDTO> getUserById(Integer id);
    List<UserDTO> getAllUsers();

    // UPDATE
    UserDTO updateUser(Integer id, UserDTO userDTO);

    // DELETE
    void deleteUser(Integer id);

    // SEARCH
    // Tìm kiếm theo username (không phân biệt hoa thường)
    List<UserDTO> findByUsernameContainingIgnoreCase(String username);

    // Tìm kiếm theo email (Không phân biệt hoa thường)
    List<UserDTO> findByEmailContainingIgnoreCase(String email);

    // Tìm kiếm theo fullname (Không phân biệt hoa thường)
    List<UserDTO> findByFullNameContainingIgnoreCase(String fullName);

    // Tìm kiếm theo từ khóa trên username, email hoặc fullname (Không phân biệt hoa thường)
    List<UserDTO> searchUsersByKeyword(String keyword);

    // CHECK EXIST
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

