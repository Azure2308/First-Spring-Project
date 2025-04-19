package com.example.startproj.service;

import com.example.startproj.dto.RegisterDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
public class RegisterService {
    public void register(@Valid RegisterDto registerDto) {
        log.info("Благодарим за регитсрацию!");
    }

}
