package com.fatec.springapi4.service;

import com.fatec.springapi4.entity.user.User;
import com.fatec.springapi4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    public List<User> listUser(){
        return userRepository.findAll();
    }

    public List<User> getByName(String name){
        User user = new User();
        user.setName(name);

        return userRepository.findAll(Example.of(user));
    }
}
