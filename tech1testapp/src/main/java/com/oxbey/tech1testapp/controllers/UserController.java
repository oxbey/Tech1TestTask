package com.oxbey.tech1testapp.controllers;

import com.oxbey.tech1testapp.entities.UserEntity;
import com.oxbey.tech1testapp.repositories.UserRepository;
import com.oxbey.tech1testapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
       UserEntity userEntity = userService.add(user);
       return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    @GetMapping("/overage/{age}")
    public ResponseEntity<List<UserEntity>> findAllByAgeAfter(@PathVariable int age){
        List<UserEntity> userEntityList = userService.findAllByAgeAfter(age);
        return new ResponseEntity<>(userEntityList, HttpStatus.OK);
    }
}
