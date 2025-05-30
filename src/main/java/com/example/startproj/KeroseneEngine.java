package com.example.startproj;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KeroseneEngine implements Engine {

    @PostConstruct
    public void postConstruct() {
        log.info("KeroseneEngine init.");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("KeroseneEngine destroy.");
    }
}
