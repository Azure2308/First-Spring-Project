package com.example.startproj.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class GoodEvent extends ApplicationEvent {

    private final String message;

    public GoodEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
