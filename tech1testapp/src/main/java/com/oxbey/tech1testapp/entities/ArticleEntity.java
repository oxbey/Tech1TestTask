package com.oxbey.tech1testapp.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "articleId")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String text;
    @Enumerated(EnumType.STRING)
    private Colour colour;
    @ManyToOne
    @JoinColumn(name = "user_userId")
    private UserEntity user;

    public ArticleEntity(String text, Colour colour) {
        this.text = text;
        this.colour = colour;
    }
}
