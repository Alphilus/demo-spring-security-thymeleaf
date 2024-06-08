package com.example.demospringsecurity.controller;

import org.springframework.web.bind.annotation.*;

// PostController
@RestController
@RequestMapping("/posts")
public class PostController {
    @GetMapping
    public String viewPosts() {
        return "Post list";
    }

    @PostMapping
    public String createPost() {
        return "Post created";
    }

    @PutMapping
    public String updatePost() {
        return "Post updated";
    }

    @DeleteMapping
    public String deletePost() {
        return "Post deleted";
    }
}
