package com.foodforcharity.app.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.foodforcharity.app.domain.entity"})
@EnableJpaRepositories(basePackages = "com.foodforcharity.app.infrastructure.repository")
@ComponentScan(basePackages = {"com.foodforcharity.app.domain"})
@ComponentScan(basePackages = {"com.foodforcharity.app.infrastructure"})
public class ApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTests.class, args);
    }

    @Test
    public void contextLoads() {
    }

}