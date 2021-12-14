package com.oxbey.tech1testapp.controllers;

import com.oxbey.tech1testapp.entities.UserEntity;
import com.oxbey.tech1testapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public void saveUser(UserEntity user){
        user = new UserEntity("name1", 28);
        userRepository.save(user);
    }
}
