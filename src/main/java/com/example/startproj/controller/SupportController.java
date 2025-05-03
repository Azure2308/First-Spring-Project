package com.example.startproj.controller;

import com.example.startproj.dto.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support/api")
public class SupportController {

    @GetMapping
    public UserDTO getSupportUser(@AuthenticationPrincipal UserDetails userDetails) {
        return new UserDTO(
                userDetails.getUsername(),
                userDetails.getAuthorities().toString()
        );
    }
}