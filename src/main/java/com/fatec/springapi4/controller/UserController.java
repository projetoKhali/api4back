package com.fatec.springapi4.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.springapi4.entity.user.ProfileType;
import com.fatec.springapi4.entity.user.User;
import com.fatec.springapi4.repository.UserRepository;
import com.fatec.springapi4.service.IUserService;


@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    UserRepository usrRepository;

    @GetMapping(value = "/list")
    public Page<User> listUsers(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return usrRepository.findAll(PageRequest.of(page, size));
    }
    
    @GetMapping(value = "/find/{user}")
    public User findById(@PathVariable("user") Long id) {
        return iUserService.findUserById(id);
    }

    @GetMapping(value = "/filter")
    public Page<User> filterUser(@RequestParam(value = "name", required = false)String name,
                                 @RequestParam(value = "login", required = false)String login,
                                 @RequestParam(value = "profileType", required = false) ProfileType profileType,
                                 Pageable pageable){
                                    return iUserService.filterUser(name, login, profileType, pageable);
                                }

    @PostMapping
    public User saveAndUpdateUser(@RequestBody User usr) {
        return iUserService.saveAndUpdateUser(usr);
    }

    @PatchMapping("/{id}")
    public User updateUserField(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
        String fieldName = requestBody.get("fieldName");
        String value = requestBody.get("value");
        return iUserService.updateUserField(id, fieldName, value);
    }

    @DeleteMapping(value = "/{userId}")
    public void delUserById(@PathVariable("userId") Long id) {
        iUserService.delUserById(id);
    }
    
}
