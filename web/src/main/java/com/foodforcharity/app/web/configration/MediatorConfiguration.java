package com.foodforcharity.app.web.configration;

import java.util.List;

import com.foodforcharity.app.mediator.CommandHandler;
import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.mediator.MediatorImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.foodforcharity.app.usecase", "com.foodforcharity.app.usecase.account.changepassword"})
public class MediatorConfiguration {

    final private Mediator mediator;

    @Autowired
    public MediatorConfiguration(List<CommandHandler<?, ?>> handlers){
        mediator = new MediatorImplementation(handlers);
    }

    @Bean
    public Mediator mediatorBean(){
        return mediator;
    }


}