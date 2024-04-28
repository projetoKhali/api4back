package com.fatec.springapi4.service;

import com.fatec.springapi4.entity.user.ProfileType;
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

    public List<User> filterUser(String name, String login, ProfileType profileType){
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setProfileType(profileType);

        return userRepository.findAll(Example.of(user));
    }
}
