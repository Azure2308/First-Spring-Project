package com.example.startproj;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Airplane {
    private final Engine keroseneEngine;

    @Autowired
    private Engine petrolEngine;

    @Setter(onMethod_ = {@Autowired, @Qualifier("petrolEngine")})
    private Engine setterEngine;

    public Airplane(Engine keroseneEngine) {
        this.keroseneEngine = keroseneEngine;
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Airplane init.");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Airplane destroy.");
    }

    public void printEngines() {
        log.info("Constructor Engine: " + keroseneEngine.getClass().getSimpleName());
        log.info("Field Engine: " + petrolEngine.getClass().getSimpleName());
        log.info("Setter Engine: " + setterEngine.getClass().getSimpleName());
    }
}
