package com.example.renting.service;

import com.example.renting.dto.PingView;

public interface PingService {
    PingView getCustomerPing();
    PingView getCustomerException();
}
