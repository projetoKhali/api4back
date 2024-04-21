package com.fatec.springapi4.controller;

import com.fatec.springapi4.entity.user.User;
import com.fatec.springapi4.repository.UserRepository;
import com.fatec.springapi4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> listUser(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/filter")
    public List<User> findByName(@RequestParam(value = "name", required = false)String name){
        if(name == null){
            return userRepository.findAll();
        }else {
            return userRepository.findByName(name);
        }
    }
}
