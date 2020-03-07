package com.foodforcharity.api;

import com.foodforcharity.api.repository.SpiceLevelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("com.foodforcharity.api.repository")
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private SpiceLevelRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(repository.count());

		System.out.println(repository.findById(Long.valueOf(1)).get().getName());

	}

}
