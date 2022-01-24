package com.oxbey.tech1testapp.services;

import com.oxbey.tech1testapp.entities.*;
import com.oxbey.tech1testapp.exceptions.*;
import com.oxbey.tech1testapp.repositories.ArticleRepository;
import com.oxbey.tech1testapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
 public class ArticleService {
     @Autowired
     UserRepository userRepository;
     @Autowired
     ArticleRepository articleRepository;

     public ArticleEntity addArticle(ArticleEntity article, Long userId) {
         UserEntity user = userRepository.findById(userId)
                 .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
         article.setUser(user);
         return articleRepository.save(article);
     }

     public List<ArticleEntity> findAllByColour(String colour) {
         List<ArticleEntity> articleEntities = articleRepository.findAllByColour(Colour.valueOf(Colour.class, colour))
                 .orElseThrow(() -> new IncorrectColourException("Article with colour " + colour + " not found or incorrect colour name"));
         return articleEntities;
     }
 }
