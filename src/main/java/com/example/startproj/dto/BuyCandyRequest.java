package com.example.startproj.dto;

import com.example.startproj.entity.CandyType;

public record BuyCandyRequest(
        CandyType candy,
        int amount
) { }
