package com.example.startproj;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("petrolEngine")
public class PetrolEngine implements Engine {

    @PostConstruct
    public void postConstruct() {
        System.out.println("PetrolEngine init.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("PetrolEngine destroy.");
    }
}
