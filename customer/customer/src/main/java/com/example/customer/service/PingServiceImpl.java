package com.example.customer.service;

import com.example.customer.config.BusinessException;
import com.example.customer.dto.PingView;
import org.springframework.stereotype.Service;

@Service
public class PingServiceImpl implements PingService {

    @Override
    public PingView getPing() {
        return new PingView("customer-service", "UP");
    }

    @Override
    public PingView getException() {
        throw new BusinessException("Customer service test exception");
    }
}
