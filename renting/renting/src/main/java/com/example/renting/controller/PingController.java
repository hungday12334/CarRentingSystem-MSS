package com.example.renting.controller;

import com.example.renting.config.BusinessException;
import com.example.renting.dto.PingView;
import com.example.renting.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/renting")
public class PingController {
    private final PingService pingService;

    @GetMapping("/ping")
    public ResponseEntity<PingView> ping() {
        return ResponseEntity.ok(pingService.getCustomerPing());
    }

    @GetMapping("/exception")
    public ResponseEntity<PingView> exception() {
        return ResponseEntity.ok(pingService.getCustomerException());
    }
}
