package com.example.startproj.requestlimit;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class RequestLimitAspect {

    private final RequestLimitService requestLimitService;

    @Before("@annotation(RequestLimit)")
    public void checkRequestLimit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        requestLimitService.checkCountRequest(name);
    }
}
