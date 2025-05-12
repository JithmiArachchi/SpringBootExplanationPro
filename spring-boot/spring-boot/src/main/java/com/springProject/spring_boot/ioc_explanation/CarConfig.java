package com.springProject.spring_boot.ioc_explanation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean
    public Car getCar(){
        return new Car();
    }

}
