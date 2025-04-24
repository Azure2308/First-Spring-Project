package com.example.startproj.config;

import com.example.startproj.property.ConfigProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
@EnableConfigurationProperties(ConfigProperty.class)
@RequiredArgsConstructor
public class MyConfig {
    private final ConfigProperty configProperty;

    @Bean
    @Profile(value = "test")
    public String testBean(){
        log.info("I`m testBean!");
        log.info(configProperty.toString());
        return "devBean";
    }

    @Bean
    @ConditionalOnBean(name = "testBean")
    public String nextBeanAfterTestBean(){
        log.info("I`m nextBeanAfterTestBean(I have a strange name...)!");
        log.info(configProperty.toString());
        return "nextBeanAfterTestBean";
    }

    @Bean
    @ConditionalOnExpression("#{'${env-variable}' != 'default'}")
    public String envVarNotDefaultBean(){
        log.info("I`m envVarNotDefaultBean(I have a strange name too...)!");
        log.info(configProperty.toString());
        return "envVarNotDefaultBean";
    }
}
