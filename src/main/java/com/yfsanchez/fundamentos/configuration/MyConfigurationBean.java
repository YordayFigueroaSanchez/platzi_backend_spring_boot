package com.yfsanchez.fundamentos.configuration;

import com.yfsanchez.fundamentos.bean.MyBean;
import com.yfsanchez.fundamentos.bean.MyBeanImpl;
import com.yfsanchez.fundamentos.bean.MyBeanImplTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    MyBean createMyBean(){
        return new MyBeanImplTwo();
    }
}
