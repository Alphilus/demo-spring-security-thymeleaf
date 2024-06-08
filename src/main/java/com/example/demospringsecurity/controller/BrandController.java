package com.example.demospringsecurity.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @GetMapping
    public String viewBrands() {
        return "Brand list";
    }

    @PostMapping
    public String createBrand() {
        return "Brand created";
    }

    @PutMapping
    public String updateBrand() {
        return "Brand updated";
    }

    @DeleteMapping
    public String deleteBrand() {
        return "Brand deleted";
    }
}
