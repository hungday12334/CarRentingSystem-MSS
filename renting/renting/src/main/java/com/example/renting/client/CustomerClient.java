package com.example.renting.client;

import com.example.renting.dto.PingView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "customer-service", configuration = CustomerErrorDecoder.class)
public interface CustomerClient {
    @GetMapping("/api/customer/ping")
    PingView getPingStatus();

    @GetMapping("/api/customer/exception")
    PingView getException();
}
