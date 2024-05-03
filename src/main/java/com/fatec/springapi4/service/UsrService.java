package com.fatec.springapi4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.entity.user.ProfileType;


import com.fatec.springapi4.entity.user.Usr;
import com.fatec.springapi4.repository.UsrRepository;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

@Service
public class UsrService implements IUsrService {

    @Autowired
    UsrRepository usrRepository;


    public Usr findUsrById(Long id) {
        Optional<Usr> usrOptional = usrRepository.findById(id);
        if (usrOptional.isPresent()) {
            return usrOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public Page<Usr> listUsrs(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return usrRepository.findAll(pageable);
    }

    public Usr saveAndUpdateUsr(Usr usr) {
        if (usr == null ||
                usr.getName() == null) {
            throw new IllegalArgumentException("Error!");
        }
        return usrRepository.save(usr);
    }

    public void delUsrById(Long id) {
        usrRepository.deleteById(id);
    }

    @Override
    public Usr updateUsrField(Long id, String fieldName, String value) {
        Usr existingUsr = usrRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));

        BeanWrapper wrapper = new BeanWrapperImpl(existingUsr);
        wrapper.setPropertyValue(fieldName, value);

        return usrRepository.save(existingUsr);
    }

    
    public Page<Usr> filterUsr(String name, String login, ProfileType profileType, Pageable pageable){
        Usr user = new Usr();
        user.setName(name);
        user.setLogin(login);
        user.setProfileType(profileType);

        return usrRepository.findAll(Example.of(user), pageable);
    }

    
}
