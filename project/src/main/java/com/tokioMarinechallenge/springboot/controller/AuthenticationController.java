package com.tokioMarinechallenge.springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tokioMarinechallenge.springboot.model.Authentication;
import com.tokioMarinechallenge.springboot.service.authentication.AuthenticationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private AuthenticationService _authenticationService;

    public AuthenticationController (AuthenticationService service){
        _authenticationService = service;
    }

    @PostMapping("/authentication")
    public ResponseEntity<String> authenticate(@RequestBody Authentication obj) throws Exception{
        String response = _authenticationService.getAuthorization(obj);
        return ResponseEntity.ok(response);
    }
    

}
