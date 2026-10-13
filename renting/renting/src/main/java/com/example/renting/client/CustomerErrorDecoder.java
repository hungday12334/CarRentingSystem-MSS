package com.example.renting.client;

import com.example.renting.config.BusinessException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 404: return new BusinessException("Lỗi 404 bên customer rồi");
            default: return new BusinessException("Lỗi bên Customer rồi");
        }
    }
}
