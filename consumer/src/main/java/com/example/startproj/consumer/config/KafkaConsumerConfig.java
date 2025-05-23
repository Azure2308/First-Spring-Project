package com.example.startproj.consumer.config;

import com.example.startproj.consumer.dto.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.*;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonLoggingErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    public static final String CONSUMER_LISTENER_FACTORY = "consumerListenerFactory";

    private final KafkaProperties kafkaProperties;
    private final ObjectMapper objectMapper;

    @Bean(CONSUMER_LISTENER_FACTORY)
    public ConcurrentKafkaListenerContainerFactory<String, MessageDto> consumerListenerFactory() {
        return buildListenerFactory(MessageDto.class);
    }

    private <T> ConcurrentKafkaListenerContainerFactory<String, T> buildListenerFactory(Class<T> clas) {
        JsonDeserializer<T> jsonDeserializer = new JsonDeserializer<>(clas, objectMapper, false);
        jsonDeserializer.addTrustedPackages("*");

        ErrorHandlingDeserializer<T> errorDeserializer = new ErrorHandlingDeserializer<>(jsonDeserializer);

        DefaultKafkaConsumerFactory<String, T> consumerFactory = new DefaultKafkaConsumerFactory<>(
                        kafkaProperties.buildConsumerProperties(),
                        new StringDeserializer(),
                        errorDeserializer
                );

        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
                factory.setConsumerFactory(consumerFactory);
                factory.setCommonErrorHandler(commonLoggingErrorHandler());
        return factory;
    }

    @Bean
    public CommonLoggingErrorHandler commonLoggingErrorHandler() {
        return new CommonLoggingErrorHandler();
    }
}