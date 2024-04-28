package com.fatec.springapi4.service;

import com.fatec.springapi4.entity.user.ProfileType;
import com.fatec.springapi4.entity.user.User;

import java.util.List;

public interface IUserService {

    List<User> filterUser(String name, String login, ProfileType profileType);

    List<User> listUser();
}
