package tn.esprit.spring.tpcafe_maramboussalem.services.Article;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle;
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


    @Override
    public List<ArticleResponse> findByNom(String nom) {
        return articleRepository.findByNomArticle(nom)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByType(TypeArticle type) {
        return articleRepository.findByTypeArticle(type)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByPrix(float prix) {
        return articleRepository.findByPrixArticle(prix)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public boolean existsByNom(String nom) {
        return articleRepository.existsByNomArticle(nom);
    }
    @Override
    public long countByType(TypeArticle type) {
        return articleRepository.countByTypeArticle(type);
    }
    @Override
    public List<ArticleResponse> findByNomContainingAndType(String nom, TypeArticle type) {
        return articleRepository.findByNomArticleContainingAndTypeArticle(nom, type)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByPrixBetweenAndType(float min, float max, TypeArticle type) {
        return articleRepository.findByPrixArticleBetweenAndTypeArticle(min, max, type)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByNomStartsWithSortedByPrix(String prefix) {
        return articleRepository.findByNomArticleIgnoreCaseStartingWithOrderByPrixArticleAsc(prefix)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findMaxPriceByType(TypeArticle type) {
        return articleRepository.findTopByTypeArticleOrderByPrixArticleDesc(type)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByNomOrTypeOrderByPrixDesc(String str, TypeArticle type) {
        return articleRepository.findByNomArticleOrTypeArticleOrderByPrixArticleDesc(str, type)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByNomStartsWith(String prefix) {
        return articleRepository.findByNomArticleStartingWith(prefix)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByNomEndsWith(String suffix) {
        return articleRepository.findByNomArticleEndingWith(suffix)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByTypeIsNull() {
        return articleRepository.findByTypeArticleIsNull()
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByPrixNotNull() {
        return articleRepository.findByPrixArticleIsNotNull()
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findWithActivePromotions() {
        return articleRepository.findArticlesWithActivePromotions()
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<ArticleResponse> findByNomContainingAndPrixBetween(String nom, float min, float max) {
        return articleRepository.findByNomArticleContainingAndPrixArticleBetween(nom, min, max)
                .stream().map(articleMapper::toDto).collect(Collectors.toList());
    }
}
