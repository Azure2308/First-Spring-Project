package com.example.startproj.controller;

import com.example.startproj.dto.RegisterDto;
import com.example.startproj.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterDto registerDto){
        registerService.register(registerDto);
    }
}
