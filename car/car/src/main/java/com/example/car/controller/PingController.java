package com.example.car.controller;

import com.example.car.dto.PingView;
import com.example.car.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/car")
public class PingController {
    private final PingService pingService;

    @GetMapping("/ping")
    public ResponseEntity<PingView> ping() {
        return ResponseEntity.ok(pingService.getPing());
    }

    @GetMapping("/exception")
    public ResponseEntity<PingView> exception() {
        return ResponseEntity.ok(pingService.getException());
    }
}
