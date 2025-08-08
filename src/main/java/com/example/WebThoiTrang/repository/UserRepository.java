package com.example.WebThoiTrang.repository;

import com.example.WebThoiTrang.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Tìm kiếm theo từ khóa trên username, email hoặc fullname (Không phân biệt hoa thường)
    @Query("SELECT u FROM User u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<User> searchUsersByKeyword(@Param("keyword") String keyword);

    List<User> findByUserId(Integer userId);

    List<User> findByUsernameContainingIgnoreCase(String username);

    List<User> findByEmailContainingIgnoreCase(String email);

    List<User> findByFullNameContainingIgnoreCase(String fullName);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
