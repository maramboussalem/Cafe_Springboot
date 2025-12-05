package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByNomArticle(String nom);
    List<Article> findByTypeArticle(TypeArticle type);
    List<Article> findByPrixArticle(float prix);
    boolean existsByNomArticle(String nom);
    long countByTypeArticle(TypeArticle type);
    List<Article> findByNomArticleContainingAndTypeArticle(String nom, TypeArticle type);
    List<Article> findByPrixArticleBetweenAndTypeArticle(float min, float max, TypeArticle type);
    List<Article> findByNomArticleIgnoreCaseStartingWithOrderByPrixArticleAsc(String prefix);
    List<Article> findTopByTypeArticleOrderByPrixArticleDesc(TypeArticle type);
    List<Article> findByNomArticleOrTypeArticleOrderByPrixArticleDesc(String nom, TypeArticle type);
    List<Article> findByNomArticleStartingWith(String prefix);
    List<Article> findByNomArticleEndingWith(String suffix);
    List<Article> findByTypeArticleIsNull();
    List<Article> findByPrixArticleIsNotNull();
    List<Article> findByMoisPromotion(int mois);

    // 15. Articles avec promotions actives
    // Attention : Assurez-vous que l'entité Promotion a un champ boolean 'active'
    @Query("SELECT DISTINCT a FROM Article a JOIN a.promotions p WHERE p.active = true")
    List<Article> findArticlesWithActivePromotions();

    List<Article> findByNomArticleContainingAndPrixArticleBetween(String nom, float min, float max);
}