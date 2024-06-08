package com.example.demospringsecurity.controller;

import org.springframework.web.bind.annotation.*;

// ProductController
@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public String viewProducts() {
        return "Product list";
    }

    @PostMapping
    public String createProduct() {
        return "Product created";
    }

    @PutMapping
    public String updateProduct() {
        return "Product updated";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "Product deleted";
    }
}
