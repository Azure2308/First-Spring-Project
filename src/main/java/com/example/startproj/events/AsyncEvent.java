package com.example.startproj.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class AsyncEvent extends ApplicationEvent {

    private final String message;

    public AsyncEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}