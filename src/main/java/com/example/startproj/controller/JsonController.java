package com.example.startproj.controller;

import com.example.startproj.dto.RequestDto;
import com.example.startproj.dto.ResponseDto;
import com.example.startproj.exceptions.BadGatewayExceptions;
import com.example.startproj.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@AllArgsConstructor
public class JsonController {

    private final RequestService requestService;

    @PostMapping("/post")
    public ResponseDto getRequest(@RequestBody RequestDto request){
        return requestService.processRequest(request);
    }
}
