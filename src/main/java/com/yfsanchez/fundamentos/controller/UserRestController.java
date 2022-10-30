package com.yfsanchez.fundamentos.controller;

import com.yfsanchez.fundamentos.caseuse.GetUser;
import com.yfsanchez.fundamentos.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }
    //create,read update delete

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }
}
