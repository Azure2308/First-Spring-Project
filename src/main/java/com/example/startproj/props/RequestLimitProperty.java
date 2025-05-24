package com.example.startproj.props;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "requests-limit")
public class RequestLimitProperty {
    private int requestsCount;
}
