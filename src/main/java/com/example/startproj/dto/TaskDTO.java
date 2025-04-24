package com.example.startproj.dto;

import java.util.List;

public record TaskDTO(
        String name,
        List<String> events
) { }
