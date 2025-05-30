package com.example.startproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/headers")
public class HeaderController {

    @GetMapping
    public String getHeaders(Model model, @RequestHeader Map<String, String> headers) {
        model.addAttribute("headers", headers);
        return "headers";
    }
}
