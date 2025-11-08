package tn.esprit.spring.tpcafe_maramboussalem.services.Article;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.ArticleMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ArticleRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService {

    ArticleRepository articleRepository;
    ArticleMapper articleMapper;

    @Override
    public ArticleResponse addArticle(ArticleRequest articleRequest) {
        Article article = articleMapper.toEntity(articleRequest);
        Article saved = articleRepository.save(article);
        return articleMapper.toDto(saved);
    }

    @Override
    public ArticleResponse selectArticleById(long id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Article introuvable"));
    }

    @Override
    public List<ArticleResponse> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleResponse updateArticle(long id, ArticleRequest request) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article introuvable : " + id));

        article.setNomArticle(request.getNomArticle());
        article.setPrixArticle(request.getPrixArticle());
        article.setTypeArticle(request.getTypeArticle());

        Article updated = articleRepository.save(article);
        return articleMapper.toDto(updated);
    }

    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    @Override
    public long countArticles() {
        return articleRepository.count();
    }

    @Override
    public boolean verifArticleById(long id) {
        return articleRepository.existsById(id);
    }

}
