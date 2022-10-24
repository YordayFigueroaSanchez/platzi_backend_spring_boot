package com.yfsanchez.fundamentos.configuration;

import com.yfsanchez.fundamentos.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBeanWithProperties {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastname}")
    private String lastname;

    @Value("${value.random}")
    private String random;

    @Bean
    MyBeanWithProperties createMyBeanWithProperties(){
        return new MyBeanWithPropertiesImpl(name, lastname);
    }
}
