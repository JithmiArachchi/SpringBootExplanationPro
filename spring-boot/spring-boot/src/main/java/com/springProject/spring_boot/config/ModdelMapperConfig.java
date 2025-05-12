package com.springProject.spring_boot.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModdelMapperConfig {
    // By using this Moddel mapper do config and inject without rush
    // to convert DTO to Entity and Entity to DTO ## check in service Impl
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
