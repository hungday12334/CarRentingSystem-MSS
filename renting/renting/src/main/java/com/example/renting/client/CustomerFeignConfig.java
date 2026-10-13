package com.example.renting.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomerFeignConfig {
    @Bean
    public ErrorDecoder hanldeCustomerErrorDecoder(){
        return new CustomerErrorDecoder();
    }
}
