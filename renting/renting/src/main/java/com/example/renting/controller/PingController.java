package com.example.renting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/renting")
public class PingController {

    @GetMapping("/ping")
    public Map<String, String> ping() {
        return Map.of(
                "service", "renting-service",
                "status", "UP"
        );
    }

    @GetMapping("/exception")
    public Map<String, String> exception() {
        throw new RuntimeException("Renting service test exception");
    }
}
