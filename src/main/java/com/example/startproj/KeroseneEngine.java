package com.example.startproj;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class KeroseneEngine implements Engine {

    @PostConstruct
    public void postConstruct() {
        System.out.println("KeroseneEngine init.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("KeroseneEngine destroy.");
    }
}
