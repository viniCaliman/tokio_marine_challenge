package com.tokioMarinechallenge.springboot.service.users;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokioMarinechallenge.springboot.model.Users;
import com.tokioMarinechallenge.springboot.repository.UsersRepository;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository _usersRepository;

    @Override
    public String addUser(Users user) throws Exception {
        try{

            Users savedData = _usersRepository.save(user);

            if(savedData == null)
                throw new Exception("Erro ao cadastrar usuário");
            
            return "Usuário cadastrado com sucesso";

        }catch(Exception ex){

            throw ex;

        }
    }

    @Override
    public Users getUserById(long id) throws Exception {
    
        try{

            Users user = _usersRepository.findById(id).get();

            if(user == null )
                throw new NoSuchElementException();

            return user;

        }catch(Exception ex){

            throw ex;

        }
    }

    @Override
    public List<Users> getUsers() throws Exception {
        try{

            List<Users> list = (List<Users>)_usersRepository.findAll();
            if(list.isEmpty())
                throw new NoSuchElementException();

            return list;

        }catch(Exception ex){

            throw ex;

        }
    }

    @Override
    public String updateUsers(Users user) throws Exception {
        try{

            Users updatedData = _usersRepository.save(user);

            if(updatedData == null )
                throw new NoSuchElementException();
            
                StringBuilder response = new StringBuilder();

                response.append("Usuário ").append(updatedData.getUserName()).append(" atualizado com sucesso");

            return response.toString();

        }catch(Exception ex){

            throw ex;

        }
    }

    @Override
    public String deleteUser(long id) throws Exception {
        try {
        
            _usersRepository.deleteById(id);

            return "Usuário deletado com sucesso";

        }catch(Exception ex){

            throw ex;

        }
    } 
}