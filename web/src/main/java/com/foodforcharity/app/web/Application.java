package com.foodforcharity.app.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EntityScan(basePackages = {"com.foodforcharity.app.domain.entity"})
@EnableJpaRepositories(basePackages = "com.foodforcharity.app.infrastructure.repository")
@ComponentScan(basePackages = {"com.foodforcharity.app.domain"})
@ComponentScan(basePackages = {"com.foodforcharity.app.infrastructure"})
@ComponentScan(basePackages = {"com.foodforcharity.app.mediator"})
@ComponentScan(basePackages = {"com.foodforcharity.app.usecase"})
@ComponentScan(basePackages = {"com.foodforcharity.app.web"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
