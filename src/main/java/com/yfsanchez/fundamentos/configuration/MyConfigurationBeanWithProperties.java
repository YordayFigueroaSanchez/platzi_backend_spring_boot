package com.yfsanchez.fundamentos.configuration;

import com.yfsanchez.fundamentos.bean.*;
import com.yfsanchez.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
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
