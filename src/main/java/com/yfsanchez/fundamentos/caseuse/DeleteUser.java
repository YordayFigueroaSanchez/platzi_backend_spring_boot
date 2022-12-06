package com.yfsanchez.fundamentos.caseuse;

import com.yfsanchez.fundamentos.entity.User;
import com.yfsanchez.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }


    public void deleteById(Long id) {
        this.userService.deleteById(id);
    }
}
