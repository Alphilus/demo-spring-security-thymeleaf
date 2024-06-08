package com.example.demospringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ProfileController
@RestController
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping
    public String viewProfile() {
        return "Profile details";
    }

    @PutMapping
    public String updateProfile() {
        return "Profile updated";
    }
}
