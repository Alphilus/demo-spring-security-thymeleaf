package com.example.demospringsecurity.controller;

import org.springframework.web.bind.annotation.*;

// CategoryController
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping
    public String viewCategories() {
        return "Category list";
    }

    @PostMapping
    public String createCategory() {
        return "Category created";
    }

    @PutMapping
    public String updateCategory() {
        return "Category updated";
    }

    @DeleteMapping
    public String deleteCategory() {
        return "Category deleted";
    }
}

