package com.example.startproj.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BadEvent extends ApplicationEvent {

    private final String message;

    public BadEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
