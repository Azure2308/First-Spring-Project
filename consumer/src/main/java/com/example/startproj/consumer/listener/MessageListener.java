package com.example.startproj.consumer.listener;

import com.example.startproj.consumer.config.KafkaConsumerConfig;
import com.example.startproj.consumer.dto.MessageDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageListener {

    @KafkaListener(topics = "test-topic", groupId = "my-group", containerFactory = KafkaConsumerConfig.CONSUMER_LISTENER_FACTORY)
    public void listen(MessageDto message) {
        log.info("Received: " + message);
    }
}