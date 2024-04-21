package com.fatec.springapi4.service;

import com.fatec.springapi4.entity.user.User;

import java.util.List;

public interface IUserService {

    public List<User> getByName(String name);
}
