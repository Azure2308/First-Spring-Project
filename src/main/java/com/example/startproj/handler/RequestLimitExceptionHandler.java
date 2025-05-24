package com.example.startproj.handler;


import com.example.startproj.exception.RequestLimitException;
import com.example.startproj.responce.ErrorResponce;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestLimitExceptionHandler {

    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(RequestLimitException.class)
    public ErrorResponce handle(RequestLimitException ex) {
        return new ErrorResponce(ex.getMessage());
    }
}
