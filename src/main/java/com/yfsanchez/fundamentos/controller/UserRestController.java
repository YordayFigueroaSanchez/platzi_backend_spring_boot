package com.yfsanchez.fundamentos.controller;

import com.yfsanchez.fundamentos.caseuse.CreateUser;
import com.yfsanchez.fundamentos.caseuse.GetUser;
import com.yfsanchez.fundamentos.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private GetUser getUser;
    private CreateUser createUser;

    public UserRestController(GetUser getUser, CreateUser createUser) {

        this.getUser = getUser;
        this.createUser = createUser;
    }
    //create,read update delete

    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> create(@RequestBody User newUser){
        return new ResponseEntity<>(this.createUser.save(newUser), HttpStatus.CREATED);
    }
}
