package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    // 8. Nom commence par (insensible à la casse), tri par prix croissant
    List<Article> findByNomArticleIgnoreCaseStartingWithOrderByPrixArticleAsc(String prefix);
    // 9. Articles d’un type avec prix maximum
    List<Article> findTopByTypeArticleOrderByPrixArticleDesc(TypeArticle type);
    // 10. Nom ou type, tri prix décroissant
    List<Article> findByNomArticleOrTypeArticleOrderByPrixArticleDesc(String nom, TypeArticle type);
    // 11. Nom commence par préfixe
    List<Article> findByNomArticleStartingWith(String prefix);
    // 12. Nom se termine par suffixe
    List<Article> findByNomArticleEndingWith(String suffix);
    // 13. Articles sans type
    List<Article> findByTypeArticleIsNull();
    // 14. Articles avec prix renseigné
    List<Article> findByPrixArticleIsNotNull();
    // 15. Articles avec promotions actives
    // Attention : Assurez-vous que l'entité Promotion a un champ boolean 'active'
    @Query("SELECT DISTINCT a FROM Article a JOIN a.promotions p WHERE p.active = true")
    List<Article> findArticlesWithActivePromotions();
    // 16. Nom contient + prix dans plage
    List<Article> findByNomArticleContainingAndPrixArticleBetween(String nom, float min, float max);
}