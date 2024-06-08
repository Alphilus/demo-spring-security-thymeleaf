package com.example.demospringsecurity.controller;

import org.springframework.web.bind.annotation.*;

// OrderController
@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public String viewOrders() {
        return "Order list";
    }

    @PostMapping
    public String createOrder() {
        return "Order created";
    }

    @PutMapping
    public String updateOrder() {
        return "Order updated";
    }
}
