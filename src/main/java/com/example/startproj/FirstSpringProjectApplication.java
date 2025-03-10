package com.example.startproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstSpringProjectApplication {

	private final Airplane airplane;

	@Autowired
	public FirstSpringProjectApplication(Airplane airplane) {
		this.airplane = airplane;
	}

	//У меня чтобы увидеть срабатывающий @PreDestroy необходимо прописать .close(). Почему-то Ctrl + C не работает.
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstSpringProjectApplication.class, args);
		Airplane airplane = context.getBean(Airplane.class);
		airplane.printEngines();
		context.close();
	}
}
