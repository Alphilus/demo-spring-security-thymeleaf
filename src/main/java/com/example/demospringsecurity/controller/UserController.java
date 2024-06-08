package com.example.demospringsecurity.controller;

import org.springframework.web.bind.annotation.*;

// UserController
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String viewUsers() {
        return "User list";
    }

    @PostMapping
    public String createUser() {
        return "User created";
    }

    @PutMapping
    public String updateUser() {
        return "User updated";
    }
}
