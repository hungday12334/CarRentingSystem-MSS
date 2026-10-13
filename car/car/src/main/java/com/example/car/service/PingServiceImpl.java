package com.example.car.service;

import com.example.car.config.BusinessException;
import com.example.car.dto.PingView;
import org.springframework.stereotype.Service;

@Service
public class PingServiceImpl implements PingService {

    @Override
    public PingView getPing() {
        return new PingView("car-service", "UP");
    }

    @Override
    public PingView getException() {
        throw new BusinessException("Car service test exception");
    }
}
