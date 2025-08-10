package com.example.WebThoiTrang.service;
import com.example.WebThoiTrang.model.User;
import com.example.WebThoiTrang.modelDTO.user.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);
    User findByUsername(String username);
}

