package com.example.renting.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExCeptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException businessException){
        log.error(businessException.getMessage());
        businessException.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(businessException.getMessage());
    }


}
