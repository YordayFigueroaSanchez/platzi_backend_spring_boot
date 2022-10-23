package com.yfsanchez.fundamentos.configuration;

import com.yfsanchez.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    MyBean createMyBean(){
        return new MyBeanImplTwo();
    }

    @Bean
    MyOperation createMyOperation(){
        return new MyOperationImpl();
    }

    @Bean
    MyBeanWithDependency createMyBeanWithDependency(){
        return new MyBeanWithDependencyImpl(new MyOperationImpl());
    }
}
