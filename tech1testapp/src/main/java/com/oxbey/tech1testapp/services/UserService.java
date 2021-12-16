package com.oxbey.tech1testapp.services;

import com.oxbey.tech1testapp.entities.UserEntity;
import com.oxbey.tech1testapp.exceptions.UserNotFoundException;
import com.oxbey.tech1testapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    UserRepository userRepository;

    public UserEntity add(UserEntity user){
        return userRepository.save(user);
    }

    public List<UserEntity> findAllByAgeAfter(int age){
        return userRepository.findAllByAgeAfter(age).
                orElseThrow(() -> new UserNotFoundException("Users over " + age + " old not found"));
    }
}
