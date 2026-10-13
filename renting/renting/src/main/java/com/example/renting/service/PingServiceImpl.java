package com.example.renting.service;

import com.example.renting.client.CustomerClient;
import com.example.renting.config.BusinessException;
import com.example.renting.dto.PingView;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PingServiceImpl implements PingService {
    private final CustomerClient customerClient;

    @Override
    public PingView getCustomerPing() {
        PingView pingView = customerClient.getPingStatus();
        return new PingView("Renting + " + pingView.service(), pingView.status());
    }

    @Override
    public PingView getCustomerException() {
        PingView pingView = customerClient.getException();
        return pingView;
    }


}
