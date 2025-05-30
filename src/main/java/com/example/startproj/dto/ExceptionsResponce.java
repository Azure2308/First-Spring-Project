package com.example.startproj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record ExceptionsResponce (
    Long timestamp,
    String path,
    String message
){}
