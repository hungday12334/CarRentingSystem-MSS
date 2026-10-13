package com.example.car.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/car")
public class PingController {

    @GetMapping("/ping")
    public Map<String, String> ping() {
        return Map.of(
                "service", "car-service",
                "status", "UP"
        );
    }

    @GetMapping("/exception")
    public Map<String, String> exception() {
        throw new RuntimeException("Car service test exception");
    }
}
