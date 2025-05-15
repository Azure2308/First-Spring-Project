package com.example.startproj.controller;

import com.example.startproj.dto.EventDto;
import com.example.startproj.service.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final EventPublisher eventPublisher;

    @PostMapping("/default")
    public ResponseEntity<?> createDefaultEvent(@RequestBody EventDto event){
        eventPublisher.publishEvent(event.message());
        return ResponseEntity.accepted().body("Success default");
    }

    @PostMapping("/async")
    public ResponseEntity<?> createAsyncEvent(@RequestBody EventDto event){
        eventPublisher.publishAsyncEvent(event.message());
        return ResponseEntity.accepted().body("Success async");
    }

    @PostMapping("/transactional")
    public ResponseEntity<?> createTransactionalEvent(@RequestBody EventDto event){
        eventPublisher.publishGoodOrBadEvent(event.message());
        return ResponseEntity.accepted().body("Success transactional");
    }
}
