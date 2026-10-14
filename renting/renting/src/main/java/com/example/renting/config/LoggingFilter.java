package com.example.renting.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter implements Ordered {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Lấy corelation
        Enumeration<String> enumCorrelationID = request.getHeaders(com.example.renting.config.Constants.CORRELATION_ID_HEADER);
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
        //Lấsy email
        Enumeration<String> enumEmail = request.getHeaders(Constants.EMAIL_HEADER);
        List<String> listEnumEmail = new ArrayList<>();
        if(enumEmail!=null){
            while(enumEmail.hasMoreElements()){
                listEnumEmail.add(enumEmail.nextElement());
            }
        }
        if(enumEmail!=null){
            log.info("Email : {}", listEnumEmail.toString());
        }else{
            log.info("Không nhận được Email");
        }
        //Lấy Role
        Enumeration<String> enumRoles = request.getHeaders(Constants.ROLES_HEADER);
        List<String> listEnumRoles = new ArrayList<>();
        if(enumRoles!=null){
            while(enumRoles.hasMoreElements()){
                listEnumRoles.add(enumRoles.nextElement());
            }
        }
        if(enumRoles!=null){
            log.info("Role : {}", listEnumRoles.toString());
        }else{
            log.info("Không nhận được Roles nao");
        }
    }

    @Override
    public int getOrder() {
        return Constants.LOGGING_ORDER;
    }
}
