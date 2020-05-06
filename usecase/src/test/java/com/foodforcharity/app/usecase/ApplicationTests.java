package com.foodforcharity.app.usecase;

import com.foodforcharity.app.mediator.Command;
import com.foodforcharity.app.mediator.CommandHandler;
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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

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

    @Autowired
    List<CommandHandler<?, ?>> handlers;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTests.class, args);
    }

    @Test
    public void printHandler(){
        for (CommandHandler<?, ?> handler : handlers) {
            ParameterizedType parameterizedType = null;

            Class<?> clazz = handler.getClass();
            while(parameterizedType == null){
                Type interfaces[] = clazz.getInterfaces();
                for(int i = 0; i < interfaces.length; ++i){
                    if(interfaces[i] == com.foodforcharity.app.mediator.CommandHandler.class){
                        parameterizedType = (ParameterizedType) clazz.getGenericInterfaces()[i];
                        break;
                    }
                }
                clazz = clazz.getSuperclass();
            }
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            String command = typeArguments[0].toString();
            String response = typeArguments[1].toString();

            command = command.substring(command.lastIndexOf('.')+1);
            response = response.substring(response.lastIndexOf("reponse.")+8);

           System.out.println("CommandHandler<" + command + ", " + response + '>');
        }
    }



}