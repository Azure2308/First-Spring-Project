package com.example.startproj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionsResponce {
    private Long timestamp;
    private String path;
    private String message;
}
