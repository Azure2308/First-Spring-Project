package com.example.startproj.actuator;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@Endpoint(id = "customActuator")
public class MyActuator {

    @ReadOperation
    public String loggingTime() {
        log.info("I`m actuator: {}", LocalDateTime.now());
        return "Custom Actuator logged";
    }
}
