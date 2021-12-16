package com.oxbey.tech1testapp.services;

import com.oxbey.tech1testapp.entities.ArticleEntity;
import com.oxbey.tech1testapp.entities.UserEntity;
import com.oxbey.tech1testapp.repositories.ArticleRepository;
import com.oxbey.tech1testapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;

    public ArticleEntity addArticle(ArticleEntity article, Long userId){
        try {
            UserEntity user = userRepository.findById(userId).get();
            article.setUser(user);
        } catch (Exception e){
            e.getLocalizedMessage();
        }
        return articleRepository.save(article);
    }
}
