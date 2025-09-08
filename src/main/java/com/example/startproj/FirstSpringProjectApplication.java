package com.example.startproj;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FirstSpringProjectApplication {
	private final Airplane airplane;
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringProjectApplication.class, args);
	}


	@PostConstruct
	public void run() {
		airplane.printEngines();
	}
}
