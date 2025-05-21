package com.example.startproj.controller;


import com.example.startproj.dto.BuyCandyRequest;
import com.example.startproj.service.CandyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candies")
@RequiredArgsConstructor
public class CandyController {

    private final CandyService candyService;

    @PostMapping("/buy")
    public String buyCandy(@RequestBody BuyCandyRequest request) {
        return candyService.buyCandy(request);
    }
}
