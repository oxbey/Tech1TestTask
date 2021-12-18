package com.oxbey.tech1testapp.repositories;

import com.oxbey.tech1testapp.entities.ArticleEntity;
import com.oxbey.tech1testapp.entities.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<List<ArticleEntity>> findAllByColour(Colour colour);

}
