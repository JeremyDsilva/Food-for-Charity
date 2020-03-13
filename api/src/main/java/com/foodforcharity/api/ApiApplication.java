package com.foodforcharity.api;

import java.util.List;
import java.util.Optional;

import com.foodforcharity.api.entities.Donee;
import com.foodforcharity.api.entities.Donor;
import com.foodforcharity.api.entities.Food;
import com.foodforcharity.api.entities.Person;
import com.foodforcharity.api.repository.DonorRepository;
import com.foodforcharity.api.repository.FoodRepository;
import com.foodforcharity.api.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	FoodRepository foodRepository;

	@Autowired
	DonorRepository donorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = personRepository.findByUsername("LucreciaSchieber").get();
		if( p instanceof Donor)
		{
			List<Food> menu = foodRepository.findAllByDonorId(  ((Donor) p).donorId);
			var donor = donorRepository.findByDonorId(menu.get(0).donorId);
			System.out.println(donor);
		}
	}

}
