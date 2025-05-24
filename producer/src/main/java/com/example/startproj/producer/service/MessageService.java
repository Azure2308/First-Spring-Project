package com.example.startproj.producer.service;

import com.example.startproj.producer.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final KafkaTemplate<String, MessageDto> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("test-topic", new MessageDto(message));
    }
}
