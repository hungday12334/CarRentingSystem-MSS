package com.example.renting.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class CorrelationFilter extends OncePerRequestFilter implements Ordered {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Enumeration<String> enumCorrelationID = request.getHeaders(Constants.CORRELATION_ID_HEADER);
        List<String> listCorrelationID = new ArrayList<>();
        if(enumCorrelationID!=null){
            while(enumCorrelationID.hasMoreElements()){
                listCorrelationID.add(enumCorrelationID.nextElement());
            }
        }
        if(listCorrelationID!=null){
            log.info("Correlation ID : {}", listCorrelationID.toString());
        }else{
            log.info("Không nhận được Correlation");
        }

    }
    @Override
    public int getOrder() {
        return Constants.CORRELATION_ORDER;
    }
}
