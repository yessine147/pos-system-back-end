package com.example.possystem.controller;

import com.example.possystem.model.Article;
import com.example.possystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.possystem.model.Category;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Retrieves all articles.
     *
     * @return ResponseEntity containing a list of all articles and HttpStatus.OK if successful,
     *         or HttpStatus.INTERNAL_SERVER_ERROR if an error occurs
     */
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        try {
            List<Article> articles = articleService.getAllArticles();
            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves an article by its ID.
     *
     * @param id The ID of the article to retrieve
     * @return ResponseEntity containing the article if found and HttpStatus.OK,
     *         or HttpStatus.NOT_FOUND if the article does not exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves articles by category.
     *
     * @param category The category of articles to retrieve
     * @return ResponseEntity containing a list of articles in the specified category and HttpStatus.OK,
     *         or HttpStatus.INTERNAL_SERVER_ERROR if an error occurs
     */
    @GetMapping("/category")
    public ResponseEntity<List<Article>> getArticlesByCategory(@RequestParam("category") Category category) {
        try {
            List<Article> articles = articleService.getArticlesByCategory(category);
            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
