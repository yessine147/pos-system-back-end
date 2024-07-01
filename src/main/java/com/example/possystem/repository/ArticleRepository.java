package com.example.possystem.repository;

import com.example.possystem.model.Article;
import com.example.possystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByCategory(Category category);
}
