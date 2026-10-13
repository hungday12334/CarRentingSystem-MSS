package com.example.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class PingController {

    @GetMapping("/ping")
    public Map<String, String> ping() {
        return Map.of(
                "service", "customer-service",
                "status", "UP"
        );
    }

    @GetMapping("/exception")
    public Map<String, String> exception() {
        throw new RuntimeException("Customer service test exception");
    }
}
