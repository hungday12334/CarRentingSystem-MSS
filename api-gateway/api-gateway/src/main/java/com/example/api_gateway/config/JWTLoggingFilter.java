package com.example.api_gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class JWTLoggingFilter implements GlobalFilter, Ordered {
    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("Start jwt logging filter");
//        return exchange.getPrincipal()
//                .filter(JwtAuthenticationToken.class::isInstance)
//                .cast(JwtAuthenticationToken.class)
//                .flatMap((p) -> {
//
//                    String email = p.getToken().getClaimAsString("email");
//                    log.info("User email is : {}", email);
//                    List<String> roles = p.getAuthorities().stream()
//                            .map((role) -> role.toString())
//                            .toList();
//                    log.info("List User ROLE: {}", roles.toString());
//                    //Tạo request mới
//                    ServerHttpRequest mutateRequest = exchange.getRequest().mutate().headers(httpHeaders -> {
//                        httpHeaders.set(Constants.EMAIL_HEADER,email);
//                        httpHeaders.set(Constants.ROLES_HEADER, roles.toString());
//                    }).build();
//                    //Tạo exchange mới
//                    ServerWebExchange mutateExchange = exchange.mutate().request(mutateRequest).build();
//                    return chain.filter(mutateExchange);
//
//                })
//                .switchIfEmpty(Mono.defer(() -> chain.filter(exchange)));
//    }

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Start jwt logging filter");
        return exchange.getPrincipal()
                .filter(JwtAuthenticationToken.class::isInstance)
                .cast(JwtAuthenticationToken.class)
                .map((p) -> {

                    String email = p.getToken().getClaimAsString("email");
                    log.info("User email is : {}", email);
                    List<String> roles = p.getAuthorities().stream()
                            .map((role) -> role.toString())
                            .toList();
                    log.info("List User ROLE: {}", roles.toString());
                    //Tạo request mới
                    ServerHttpRequest mutateRequest = exchange.getRequest().mutate().headers(httpHeaders -> {
                        httpHeaders.set(Constants.EMAIL_HEADER,email);
                        httpHeaders.set(Constants.ROLES_HEADER, roles.toString());
                    }).build();
                    //Tạo exchange mới
                    ServerWebExchange mutateExchange = exchange.mutate().request(mutateRequest).build();
                    return mutateExchange;

                })
                .defaultIfEmpty(exchange)
                .flatMap(ex -> chain.filter(ex));
    }
    @Override
    public int getOrder() {
        return Constants.JWT_LOGGING_ODER;
    }
}
