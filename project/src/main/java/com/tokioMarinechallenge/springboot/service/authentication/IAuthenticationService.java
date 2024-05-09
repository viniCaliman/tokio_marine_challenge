package com.tokioMarinechallenge.springboot.service.authentication;

import org.springframework.stereotype.Service;

import com.tokioMarinechallenge.springboot.model.Authentication;

@Service
public interface IAuthenticationService {

    String getAuthorization(Authentication authentication) throws Exception;

}
