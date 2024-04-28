package com.fatec.springapi4.controller;

import com.fatec.springapi4.entity.user.ProfileType;
import com.fatec.springapi4.entity.user.User;
import com.fatec.springapi4.repository.UserRepository;
import com.fatec.springapi4.service.IUserService;
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

    @Autowired
    IUserService userService;

    @GetMapping
    public List<User> listUser(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/filter")
    public List<User> findByName(@RequestParam(value = "name", required = false)String name,
                                 @RequestParam(value = "login", required = false)String login,
                                 @RequestParam(value = "profileType", required = false) ProfileType profileType){
        if(name == null&&login == null&&profileType == null){
            return userService.listUser();
        }else {
            return userService.filterUser(name,login,profileType);
        }
    }
}
