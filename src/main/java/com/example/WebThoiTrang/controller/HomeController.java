package com.example.WebThoiTrang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/Home")
    public String homePage() {
        return "Home"; // trả về tên file home.html (không cần .html)
    }
}
