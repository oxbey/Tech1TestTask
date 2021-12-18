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

    @PostMapping("/addUser")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        UserEntity userEntity = userService.add(user);
        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    @GetMapping("/overage/{age}")
    public ResponseEntity<List<UserEntity>> getAllUsersByAgeAfter(@PathVariable int age) {
        List<UserEntity> userEntityList = userService.findAllByAgeAfter(age);
        return new ResponseEntity<>(userEntityList, HttpStatus.OK);
    }

    @GetMapping("/getUserByArticleColour/{colour}")
    public ResponseEntity<List<UserEntity>> getAllUsersByColour(@PathVariable String colour) {
        List<UserEntity> users = userService.findAllByArticlesColour(colour);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUserWithArticlesCountGreater/{count}")
    public ResponseEntity<List<String>> getAllUsersWithArticlesCountGreater(@PathVariable int count) {
        List<String> users = userService.findAllWithArticlesCountGreater(count);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
