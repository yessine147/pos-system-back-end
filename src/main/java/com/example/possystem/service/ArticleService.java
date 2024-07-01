package com.example.possystem.service;

import com.example.possystem.model.Article;
import com.example.possystem.model.Category;
import com.example.possystem.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    /**
     * Retrieves all articles from the database.
     *
     * @return List of all articles
     */
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /**
     * Retrieves an article by its ID.
     *
     * @param id The ID of the article to retrieve
     * @return The article if found, or null if not found
     */
    public Article getArticleById(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return optionalArticle.orElse(null);
    }

    /**
     * Retrieves articles belonging to a specific category.
     *
     * @param category The category of articles to retrieve
     * @return List of articles belonging to the specified category
     */
    public List<Article> getArticlesByCategory(Category category) {
        return articleRepository.findByCategory(category);
    }

}
