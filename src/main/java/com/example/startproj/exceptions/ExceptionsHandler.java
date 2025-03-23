package com.example.startproj.exceptions;

import com.example.startproj.dto.ExceptionsResponce;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadGatewayExceptions.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ExceptionsResponce handleBadGateway(BadGatewayExceptions ex, HttpServletRequest request) {
        return new ExceptionsResponce(System.currentTimeMillis(), request.getRequestURI(), ex.getMessage());
    }
}
