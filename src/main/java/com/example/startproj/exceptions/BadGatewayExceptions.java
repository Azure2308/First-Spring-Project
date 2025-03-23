package com.example.startproj.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class BadGatewayExceptions extends RuntimeException {
    public BadGatewayExceptions(String message){
        super(message);
    }
}
