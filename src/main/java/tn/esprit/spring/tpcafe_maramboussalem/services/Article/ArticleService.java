package tn.esprit.spring.tpcafe_maramboussalem.services.Article;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ArticleRepository;

import java.util.List;

import static tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle.BOISSON;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService {

    public ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> saveArticles(List<Article> articles) {
        return articleRepository.saveAll(articles);
    }

    @Override
    public Article selectArticleById(long id) {
        return articleRepository.findById(id).get();

    }

    @Override
    public List<Article> selectAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }

    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public long countArticles() {
        return articleRepository.count();
    }

    @Override
    public boolean verifArticleById(long id) {
        return articleRepository.existsById(id);
    }

    @Override
    public Article selectArticleByIdWithOrElse(long id) {
        Article article = Article.builder()
                .nomArticle("Apla").prixArticle(145).typeArticle(BOISSON)
                .build();
        return articleRepository.findById(id).orElse(article);
    }

    @Override
    public Article selectArticleByIdWithGet(long id) {
        return articleRepository.findById(id).get();
    }

}
