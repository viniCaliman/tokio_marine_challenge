package com.tokioMarinechallenge.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokioMarinechallenge.springboot.model.Users;
import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

   List<Users> findByUserName(String userName);
} 
