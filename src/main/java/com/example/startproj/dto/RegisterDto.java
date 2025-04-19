package com.example.startproj.dto;

import com.example.startproj.validator.PhoneNumber;
import com.example.startproj.validator.ValidName;
import jakarta.validation.constraints.Email;

public record RegisterDto(
        @ValidName String name,
        @Email String email,
        @PhoneNumber String phoneNumber
) { }
