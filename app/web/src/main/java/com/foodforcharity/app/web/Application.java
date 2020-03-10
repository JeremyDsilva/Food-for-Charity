package com.foodforcharity.app.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages =  { "com.foodforcharity.app.usecase", "com.foodforcharity.app.service"})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(GuestAppApplication.class, args);
	}
	
}
