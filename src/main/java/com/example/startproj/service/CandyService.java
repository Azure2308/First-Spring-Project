package com.example.startproj.service;

import com.example.startproj.dto.BuyCandyRequest;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;



//Вроде как лучше всего через Аспекты, верно?
//Ну в задании не сказано, как именно))))
@Slf4j
@Service
@RequiredArgsConstructor
public class CandyService {

    private final MeterRegistry meterRegistry;

    public String buyCandy(BuyCandyRequest request) {
        long startTimer = System.nanoTime();

        meterRegistry.counter("requests.count").increment();
        meterRegistry.counter("candies.sold", "type", request.candy().name()).increment(request.amount());
        meterRegistry.timer("requests.duration").record(System.nanoTime() - startTimer, TimeUnit.NANOSECONDS);

        log.info("Bought {} of {}", request.amount(), request.candy());
        return "Bought " + request.amount() + " of " + request.candy();
    }
}
