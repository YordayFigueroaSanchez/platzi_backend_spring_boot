package com.yfsanchez.fundamentos.caseuse;

import com.yfsanchez.fundamentos.entity.User;
import com.yfsanchez.fundamentos.service.UserService;

import java.util.List;

public class GetUserImpl implements GetUser {
    private UserService userService;

    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAll();
    }
}
