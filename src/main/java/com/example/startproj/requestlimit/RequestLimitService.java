package com.example.startproj.requestlimit;


import com.example.startproj.exception.RequestLimitException;
import com.example.startproj.props.RequestLimitProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestLimitService {
    private final RequestLimitProperty requestLimitProperty;
    private final Map<String, Integer> requestsCount = new HashMap<>();

    public synchronized void checkCountRequest(String name) {
        int currentCount = requestsCount.getOrDefault(name, 0);
        if (currentCount >= requestLimitProperty.getRequestsCount()) {
            throw new RequestLimitException("Request limit for method: " + name);
        }

        requestsCount.put(name, currentCount + 1);
    }
}
