package com.fatec.springapi4.service;

import java.util.List;

import com.fatec.springapi4.entity.user.ProfileType;

import com.fatec.springapi4.entity.user.Usr;

public interface IUsrService {
    
    public Usr findUsrById(Long id);

    public List<Usr> listUsrs();

    public Usr saveAndUpdateUsr(Usr usr);

    public void delUsrById(Long id);

    public Usr updateUsrField(Long id, String fieldName, String value);

    public List<Usr> filterUsr(String name, String login, ProfileType profileType);

}
