package com.example.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain serverHttpSecurity(ServerHttpSecurity security) {
        return security.
                csrf((e) -> e.disable())
                .authorizeExchange((authorizeExchangeSpec -> authorizeExchangeSpec
                        .pathMatchers("/actuator/health/**", "/public").permitAll()
                        .pathMatchers("/renting-service/**").hasRole("CUSTOMER")
                        .anyExchange().authenticated()
                ))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtSpec -> {
                    jwtSpec.jwtAuthenticationConverter(jwtAuthenticationConverter());
                })).build();
    }
    //Hàm này cho phép dùng đối tượng KeyCloakRoleConverter trong vệc convert dữ liệu từ jwt sang GrantAutho
    @Bean
    public Converter<Jwt, Mono<AbstractAuthenticationToken>> jwtAuthenticationConverter() {

        JwtAuthenticationConverter converter =
                new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(
                new KeyCloakRoleConverter()
        );

        return new ReactiveJwtAuthenticationConverterAdapter(converter);
    }
}