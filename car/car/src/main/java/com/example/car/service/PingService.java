package com.example.car.service;

import com.example.car.dto.PingView;

public interface PingService {
    PingView getPing();

    PingView getException();
}
