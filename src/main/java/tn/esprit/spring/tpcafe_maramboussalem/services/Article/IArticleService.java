package tn.esprit.spring.tpcafe_maramboussalem.services.Article;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;

import java.util.List;

public interface IArticleService {

    ArticleResponse addArticle(ArticleRequest articleRequest);

    ArticleResponse selectArticleById(long id);
    List<ArticleResponse> getAllArticles();

    ArticleResponse updateArticle(long id, ArticleRequest request);

    void deleteArticleById(long id);
    void deleteAllArticles();

    long countArticles();
    boolean verifArticleById(long id);
}


