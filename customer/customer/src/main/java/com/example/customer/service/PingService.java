package com.example.customer.service;

import com.example.customer.dto.PingView;

public interface PingService {
    PingView getPing();

    PingView getException();
}
