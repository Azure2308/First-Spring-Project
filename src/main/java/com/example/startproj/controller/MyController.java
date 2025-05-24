package com.example.startproj.controller;


import com.example.startproj.requestlimit.RequestLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @RequestLimit
    @GetMapping("/getForLimit")
    public String getRequestForLimit() {
        return " =) ";
    }
}
