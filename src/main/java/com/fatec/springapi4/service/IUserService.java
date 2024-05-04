package com.fatec.springapi4.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fatec.springapi4.entity.user.ProfileType;

import com.fatec.springapi4.entity.user.User;

public interface IUserService {
    
    public User findUserById(Long id);

    public Page<User> listUsers(int pageNumber, int pageSize);

    public User saveAndUpdateUser(User usr);

    public void delUserById(Long id);

    public User updateUserField(Long id, String fieldName, String value);

    public Page<User> filterUser(String name, String login, ProfileType profileType, Pageable pageable);

}
