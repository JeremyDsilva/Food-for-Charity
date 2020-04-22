package com.foodforcharity.app.usecase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.foodforcharity.app.domain.entity"})
@EnableJpaRepositories(basePackages = "com.foodforcharity.app.infrastructure.repository")
@ComponentScan(basePackages = {"com.foodforcharity.app.domain"})
@ComponentScan(basePackages = {"com.foodforcharity.app.infrastructure"})
@ComponentScan(basePackages = {"com.foodforcharity.app.mediator"})
@ComponentScan(basePackages = {"com.foodforcharity.app.usecase"})
public class ApplicationTests {

    @Autowired
    private ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTests.class, args);
    }

    @Test
    public void contextLoads() {
        System.out.println("===============================================");
        System.out.println("The beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println("===============================================");
    }

}