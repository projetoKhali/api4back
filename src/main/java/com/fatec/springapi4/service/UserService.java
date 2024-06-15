package com.fatec.springapi4.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatec.springapi4.Validation;
import com.fatec.springapi4.entity.user.ProfileType;


import com.fatec.springapi4.entity.user.User;
import com.fatec.springapi4.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository usrRepository;


    public User findUserById(Long id) {
        Optional<User> usrOptional = usrRepository.findById(id);
        if (usrOptional.isPresent()) {
            return usrOptional.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public Page<User> listUsers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return usrRepository.findAll(pageable);
    }

    public User saveAndUpdateUser(User usr) {
        Optional<String> error = Validation.validateUser(usr);
        if (error.isPresent()) {
            throw new IllegalArgumentException("Error: Invalid user: " + error.get());
        }
        return usrRepository.save(usr);
    }

    public void delUserById(Long id) {
        usrRepository.deleteById(id);
    }

    @Override
    public User updateUserField(Long id, String fieldName, String value) {
        User existingUser = usrRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));

        BeanWrapper wrapper = new BeanWrapperImpl(existingUser);
        wrapper.setPropertyValue(fieldName, value);

        return usrRepository.save(existingUser);
    }

    public User updateUser(Long id, Map<String, Object> fields) {
        
        User user = usrRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Entity not found: " + id));

        fields.forEach((field,value) ->{
            switch (field) {
                case "login":
                    user.setLogin((String)value);
                    break;
                case "name":
                    user.setName((String)value);
                    break;
                case "profileType":
                    user.setProfileType((ProfileType)value);
                    break;
                default:
                    // Caso você queira lidar com campos desconhecidos ou ignorá-los
                    System.out.println("Undeffined field: " + field);
                    break;
            }
        });


        return usrRepository.save(user);
    }

    public Page<User> filterUser(String name, String login, ProfileType profileType, Pageable pageable){
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setProfileType(profileType);

        return usrRepository.findAll(Example.of(user), pageable);
    }

    
}
