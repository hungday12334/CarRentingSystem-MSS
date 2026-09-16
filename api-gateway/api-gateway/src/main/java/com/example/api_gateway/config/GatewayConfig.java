package com.example.api_gateway.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        logger.info("Start to solve Request");
//        return builder.routes()
//                .route("currency-conversion-service", r -> r
//                        .path("/currency-conversion-service/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://CURRENCY-CONVERSION-SERVICE")
//
//                )
//                .route("currency-exchange-service", r -> r
//                        .path("/currency-exchange-service/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://CURRENCY-EXCHANGE-SERVICE")
//                )
//                .route("customer-service", r -> r
//                        .path("/customer-service/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("http://localhost:8000")
//                )
//                .build();
//    }
}