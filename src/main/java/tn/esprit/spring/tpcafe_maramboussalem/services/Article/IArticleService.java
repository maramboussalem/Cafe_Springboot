package tn.esprit.spring.tpcafe_maramboussalem.services.Article;

import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;

import java.util.List;

public interface IArticleService {

    Article addArticle(Article article);
    List<Article> saveArticles(List<Article> articles);
    Article selectArticleById(long id);
    List<Article> selectAllArticles();
    void deleteArticle(Article article);
    void deleteAllArticles();
    void deleteArticleById(long id);
    long countArticles();
    boolean verifArticleById(long id);
    Article selectArticleByIdWithOrElse(long id) ;
    Article selectArticleByIdWithGet(long id) ;
}


