package com.example.startproj.controller;

import com.example.startproj.dto.Request;
import com.example.startproj.exceptions.BadGatewayExceptions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class JsonController {

    private final Random random = new Random();

    @PostMapping("/post")
    public Request getRequest(@RequestBody Request request){
        long id = random.nextLong(1000) + 1;
        //long id = 0L;

        if (id == 0) {
            throw new BadGatewayExceptions("Id can't be equal to 0: %s".formatted(request.toString()));
        }

        request.getInfo().setId(id);
        return request;
    }
}
