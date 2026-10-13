package com.example.api_gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
@Slf4j
public class LoggingFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Start logging filter in API Gateway");
        return chain.filter(exchange).doFinally((e) -> {
            log.info("Finish logging filter in API Gateway");
        });
    }

    @Override
    public int getOrder() {
        return Constants.LOGGING_ORDER;
    }
}
