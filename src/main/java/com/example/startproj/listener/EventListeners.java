package com.example.startproj.listener;
import com.example.startproj.events.AsyncEvent;
import com.example.startproj.events.BadEvent;
import com.example.startproj.events.Event;


import com.example.startproj.events.GoodEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
public class EventListeners {

    @EventListener
    public void handleEvent(Event event) {
        log.info("EventListener - Event. Message: {}", event.getMessage());
    }

    @Async
    @SneakyThrows
    @EventListener
    public void handleAsyncEvent(AsyncEvent event) {
        Thread.sleep(10000);
        log.info("EventListener - AsyncEvent. Message: {}", event.getMessage());
    }

    @TransactionalEventListener()
    public void handleGoodEvent(GoodEvent event) {
        log.info("EventListener - GoodEvent. Message: {}", event.getMessage());
    }

    @TransactionalEventListener()
    public void handleBadEvent(BadEvent event) {
        log.info("EventListener - BadEvent. Message: {}", event.getMessage());
    }

}
