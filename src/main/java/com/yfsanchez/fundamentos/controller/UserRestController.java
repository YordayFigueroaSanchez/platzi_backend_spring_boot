package com.yfsanchez.fundamentos.controller;

import com.yfsanchez.fundamentos.caseuse.CreateUser;
import com.yfsanchez.fundamentos.caseuse.DeleteUser;
import com.yfsanchez.fundamentos.caseuse.GetUser;
import com.yfsanchez.fundamentos.caseuse.UpdateUser;
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
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {

        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
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

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        this.deleteUser.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(this.updateUser.update(newUser, id),HttpStatus.OK);
    }

}
