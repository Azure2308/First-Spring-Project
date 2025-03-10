package com.example.startproj;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Airplane {

    //Внедрение через констуктор.
    //Тут внедрится KeroseneEngine, так как у него аннотация @Primal
    private final Engine constEngine;

    //Внедрение через поле.
    //Тут уже внедрится PetrolEngine, так как мы его явно указываем через @Qualifier
    @Autowired
    @Qualifier("petrolEngine")
    private Engine fieldEngine;

    //Внедрение через сеттер.
    private Engine setterEngine;

    public Airplane(Engine constEngine) {
        this.constEngine = constEngine;
    }

    @Autowired
    public void setSetterEngine(Engine setterEngine) {
        this.setterEngine = setterEngine;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Airplane init.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Airplane destroy.");
    }

    public void printEngines() {
        System.out.println("Constructor Engine: " + constEngine.getClass().getSimpleName());
        System.out.println("Field Engine: " + fieldEngine.getClass().getSimpleName());
        System.out.println("Setter Engine: " + setterEngine.getClass().getSimpleName());
    }
}
