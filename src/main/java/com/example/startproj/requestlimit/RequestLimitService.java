package com.example.startproj.requestlimit;


import com.example.startproj.exception.RequestLimitException;
import com.example.startproj.props.RequestLimitProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class RequestLimitService {

    private final RequestLimitProperty requestLimitProperty;

    private final Map<String, AtomicInteger> requestsCount = new ConcurrentHashMap<>();

    public void checkCountRequest(String name) {
        int currentCount = requestsCount
                .computeIfAbsent(name, key -> new AtomicInteger())
                .incrementAndGet();

        if (currentCount > requestLimitProperty.getRequestsCount()) {
            throw new RequestLimitException("Request limit for method: " + name);
        }
    }
}
