package com.tokioMarinechallenge.springboot.service.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tokioMarinechallenge.springboot.model.Users;

@Service
public interface IUsersService {

    public String addUser(Users user) throws Exception;

    public Users getUserById(long id) throws Exception;

    public List<Users> getUsers() throws Exception;

    public String updateUsers(Users user) throws Exception;

    public String deleteUser(long id)  throws Exception;

}
