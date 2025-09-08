package com.example.startproj;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PetrolEngine implements Engine {

    @PostConstruct
    public void postConstruct() {
        log.info("PetrolEngine init.");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("PetrolEngine destroy.");
    }
}
