package com.oxbey.tech1testapp.controllers;


import com.oxbey.tech1testapp.entities.ArticleEntity;
import com.oxbey.tech1testapp.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/addArticle")
    public ResponseEntity<ArticleEntity> addArticle(@RequestBody ArticleEntity article,
                                                    @RequestParam Long userId) {
        ArticleEntity articleEntity = articleService.addArticle(article, userId);
        return new ResponseEntity<>(articleEntity, HttpStatus.CREATED);
    }

    @GetMapping("/getByColor/{colour}")
    public ResponseEntity<List<ArticleEntity>> findAllByColour(@PathVariable String colour) {
        List<ArticleEntity> articleEntityList = articleService.findAllByColour(colour);
        return new ResponseEntity<>(articleEntityList, HttpStatus.OK);
    }
}
