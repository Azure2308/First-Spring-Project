package com.example.startproj.producer.controller;


import com.example.startproj.producer.dto.MessageDto;
import com.example.startproj.producer.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send")
    public void send(@RequestBody String message) {
        messageService.sendMessage(message);
    }
}
