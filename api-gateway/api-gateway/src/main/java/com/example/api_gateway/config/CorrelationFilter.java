package com.example.api_gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class CorrelationFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Start correlation filter in API Gateway");
        ServerHttpRequest request = exchange.getRequest();
        List<String> correlationID = request.getHeaders().get(Constants.CORRELATION_ID_HEADER);
        List<String> jwtToken = request.getHeaders().get(HttpHeaders.AUTHORIZATION);
        if(jwtToken!=null || !jwtToken.isEmpty()){
            log.info("Jwt token : {}", jwtToken.toString());
        }else{
            log.info("Không nhận được jwt");
        }
        ServerHttpRequest mutateRequest = null;
        if(correlationID==null || correlationID.isEmpty()){
            String newCorrelationId = UUID.randomUUID().toString();
            mutateRequest = request.mutate().header(Constants.CORRELATION_ID_HEADER,newCorrelationId).build();
        }else{
            log.info("Correlation Id: {}", correlationID.toString());
        }

        return chain.filter(exchange.mutate().request(mutateRequest).build()).doFinally((e) ->{
            log.info("Finish Correlation Filter in API Gateway");
        });
    }

    @Override
    public int getOrder() {
        return Constants.CORRELATION_ORDER;
    }
}
