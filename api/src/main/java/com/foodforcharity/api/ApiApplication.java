package com.foodforcharity.api;

import com.foodforcharity.api.entities.Donee;
import com.foodforcharity.api.entities.Donor;
import com.foodforcharity.api.entities.Person;
import com.foodforcharity.api.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = repository.findByUsername("Sonic").get();
		System.out.println(Donee.class.isInstance(p));
	}

}
