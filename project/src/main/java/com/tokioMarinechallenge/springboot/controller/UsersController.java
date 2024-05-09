package com.tokioMarinechallenge.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokioMarinechallenge.springboot.model.Users;
import com.tokioMarinechallenge.springboot.service.users.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class UsersController {

    //@Autowired
    private UsersService _usersService;

    public UsersController (UsersService service){
        _usersService = service;
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody Users user) throws Exception{
        String response = _usersService.addUser(user);
        return ResponseEntity.ok(response);
    }
    

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") long id) throws Exception{
        Users response = _usersService.getUserById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody Users user) throws Exception{
        String response = _usersService.updateUsers(user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws Exception{
        String response = _usersService.deleteUser(id);
        return ResponseEntity.ok(response);
    }

}
