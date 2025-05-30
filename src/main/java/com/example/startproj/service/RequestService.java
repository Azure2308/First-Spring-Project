package com.example.startproj.service;

import com.example.startproj.dto.InfoDto;
import com.example.startproj.dto.RequestDto;
import com.example.startproj.dto.ResponseDto;
import com.example.startproj.exceptions.BadGatewayExceptions;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RequestService {

    private final Random random = new Random();

    public ResponseDto processRequest(RequestDto requestDto) {
        //long id = random.nextLong(1000) + 1;
        long id = 0L;

        if (id == 0) {
            throw new BadGatewayExceptions("Id can't be equal to 0: %s".formatted(requestDto.toString()));
        }

        InfoDto newInfo = new InfoDto(id, requestDto.info().date());
        return new ResponseDto(requestDto.price(), newInfo);
    }
}
