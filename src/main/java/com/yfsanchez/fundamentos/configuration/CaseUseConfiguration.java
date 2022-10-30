package com.yfsanchez.fundamentos.configuration;

import com.yfsanchez.fundamentos.caseuse.GetUser;
import com.yfsanchez.fundamentos.caseuse.GetUserImpl;
import com.yfsanchez.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImpl(userService);
    }
}
