package com.oxbey.tech1testapp.services;

import com.oxbey.tech1testapp.entities.ArticleEntity;
import com.oxbey.tech1testapp.entities.UserEntity;
import com.oxbey.tech1testapp.exceptions.UserNotFoundException;
import com.oxbey.tech1testapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleService articleService;

    public UserEntity add(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> findAllByAgeAfter(int age) {
        return userRepository.findAllByAgeAfter(age).
                orElseThrow(() -> new UserNotFoundException("Users over " + age + " old not found"));
    }

    public List<UserEntity> findAllByArticlesColour(String colour) {
        List<ArticleEntity> articles = articleService.findAllByColour(colour);
        List<UserEntity> usersList = new ArrayList<>() {{
            for (int i = 0; i < articles.size(); i++) {
                add(articles.get(i).getUser());
            }
        }};
        return usersList.stream().distinct().collect(Collectors.toList());
    }

    public List<String> findAllWithArticlesCountGreater(int count) {
        List<String> usersList = userRepository.findAll().stream()
                .filter((user) -> user.getArticles().size() > count)
                .distinct()
                .map((user) -> user.getName())
                .collect(Collectors.toList());
        return usersList;
    }

    public String printSomeData(String data){
        return data;
    }
}
