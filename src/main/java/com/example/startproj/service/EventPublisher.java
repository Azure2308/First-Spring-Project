package com.example.startproj.service;

import com.example.startproj.events.AsyncEvent;
import com.example.startproj.events.BadEvent;
import com.example.startproj.events.Event;
import com.example.startproj.events.GoodEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent(String message) {
        log.info("Publishing Event. Message: {}", message);
        eventPublisher.publishEvent(new Event(this, message));
    }

    public void publishAsyncEvent(String message) {
        log.info("Publishing AsyncEvent. Message: {}", message);
        eventPublisher.publishEvent(new AsyncEvent(this, message));
    }

    @Transactional
    public void publishGoodOrBadEvent(String message) {
        log.info("Publishing GoodEvent. Message: {}", message);
        eventPublisher.publishEvent(new GoodEvent(this, message));

        if (message.equals("I`m lanoitcasnart")) {
            log.info("Publishing BadEvent. Message: {}", message);
            eventPublisher.publishEvent(new BadEvent(this, message));
            throw new RuntimeException("Error, please write I`m transactional");
        }
    }
}
