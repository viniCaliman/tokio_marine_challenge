package com.tokioMarinechallenge.springboot.service.authentication;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.tokioMarinechallenge.springboot.model.Authentication;
import com.tokioMarinechallenge.springboot.model.Users;
import com.tokioMarinechallenge.springboot.repository.UsersRepository;

@Service
public class AuthenticationService implements IAuthenticationService {

    private UsersRepository _usersRepository;

    public AuthenticationService (UsersRepository userRepository){
        _usersRepository = userRepository;
    }

    @Override
    public String getAuthorization(Authentication authentication) throws Exception{
        try {
            List<Users> users = _usersRepository.findByUserName(authentication.getUsername());

            if(users.size() == 0)
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);

            if (!authentication.getPassword().equals(users.get(0).getPassword()))
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
            

            return "Ok";

        } catch (Exception e) {
            throw e;
        }
    }

}
