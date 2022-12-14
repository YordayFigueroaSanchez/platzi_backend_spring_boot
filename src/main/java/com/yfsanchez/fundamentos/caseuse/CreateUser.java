package com.yfsanchez.fundamentos.caseuse;

import com.yfsanchez.fundamentos.entity.User;
import com.yfsanchez.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser){
        return userService.save(newUser);
    }
}
