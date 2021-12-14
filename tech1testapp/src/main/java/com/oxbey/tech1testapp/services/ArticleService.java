package com.oxbey.tech1testapp.services;

import com.oxbey.tech1testapp.entities.ArticleEntity;

public interface ArticleService {
    ArticleEntity addArticle(ArticleEntity article, Long userId);
}
