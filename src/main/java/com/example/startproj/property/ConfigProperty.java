package com.example.startproj.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "my-config")
public class ConfigProperty {
    String name;
    List<String> list;
}
