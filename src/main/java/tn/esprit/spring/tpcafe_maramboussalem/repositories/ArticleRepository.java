package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
