package com.example.startproj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api")
public class PublicController {

    @GetMapping
    public String getPublicUser() {
        return "I`m public =(";
    }
}
