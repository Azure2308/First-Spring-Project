package com.example.startproj.exception;

import com.example.startproj.dto.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class RegisterExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(ConstraintViolationException ex) {
        return new ErrorResponse("У вас неверно заполнены поля!", ex.getConstraintViolations().stream()
                .collect(Collectors.toMap(violation -> violation.getPropertyPath().toString(), ConstraintViolation::getMessage)));
    }
}
