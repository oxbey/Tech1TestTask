package com.oxbey.tech1testapp.services.impls;

import com.oxbey.tech1testapp.entities.ArticleEntity;
import com.oxbey.tech1testapp.entities.UserEntity;
import com.oxbey.tech1testapp.repositories.ArticleRepository;
import com.oxbey.tech1testapp.repositories.UserRepository;
import com.oxbey.tech1testapp.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public ArticleEntity addArticle(ArticleEntity article, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        article.setUser(user);
        return articleRepository.save(article);
    }
}
