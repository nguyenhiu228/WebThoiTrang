package com.example.WebThoiTrang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestRoleController {
    @GetMapping("/user/hello")
    public String userHello() {
        return "Hello USER or ADMIN!";
    }

    @GetMapping("/admin/hello")
    public String adminHello() {
        return "Hello ADMIN!";
    }
}
