package com.example.customer.controller;

import com.example.customer.dto.PingView;
import com.example.customer.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
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
