package com.yfsanchez.fundamentos.caseuse;

import com.yfsanchez.fundamentos.entity.User;
import com.yfsanchez.fundamentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }


    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
