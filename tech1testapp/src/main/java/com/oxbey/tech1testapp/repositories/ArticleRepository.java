package com.oxbey.tech1testapp.repositories;

import com.oxbey.tech1testapp.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

}
