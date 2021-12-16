package com.oxbey.tech1testapp.db;

import com.oxbey.tech1testapp.entities.UserEntity;
import com.oxbey.tech1testapp.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class AaUserTable implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        List<UserEntity> users = new ArrayList<>(){{
            for (int i = 0; i < 10; i++){
                String name = RandomStringUtils.randomAlphabetic(6,10);
                int age = 20 + random.nextInt(40);
                add(new UserEntity(name, age));
            }
        }};
        userRepository.saveAll(users);
    }
}
