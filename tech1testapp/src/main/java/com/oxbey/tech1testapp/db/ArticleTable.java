package com.oxbey.tech1testapp.db;

import com.oxbey.tech1testapp.entities.ArticleEntity;
import com.oxbey.tech1testapp.entities.Colour;
import com.oxbey.tech1testapp.services.ArticleService;
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
    ArticleService articleService;
    Random random = new Random();

    private Colour randomColour() {
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
                add(new ArticleEntity(text, randomColour()));

            }
        }};
        articles.forEach((article) -> articleService.addArticle(article, (long)(1+random.nextInt(10))));
    }
}
