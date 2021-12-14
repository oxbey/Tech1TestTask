package com.oxbey.tech1testapp.db;

import com.oxbey.tech1testapp.entities.ArticleEntity;
import com.oxbey.tech1testapp.entities.Colour;
import com.oxbey.tech1testapp.repositories.ArticleRepository;
import com.oxbey.tech1testapp.services.impls.ArticleServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ArticleTable implements CommandLineRunner {

    @Autowired
    ArticleServiceImpl articleService;
    Random random = new Random();

    private Colour randomColor() {
        int length = Colour.values().length;
        Colour[] values = Colour.values();
        int temp = ThreadLocalRandom.current().nextInt(length);
        return values[temp];
    }

    @Override
    public void run(String... args) throws Exception {
        List<ArticleEntity> articles = new ArrayList<>(){{
            for (int i = 0; i < 40; i++) {
                String text = RandomStringUtils.randomAlphabetic(20);
                add(new ArticleEntity(text, randomColor()));
            }
        }};
        articles.forEach((article -> articleService.addArticle(article, 1L)));
    }
}
