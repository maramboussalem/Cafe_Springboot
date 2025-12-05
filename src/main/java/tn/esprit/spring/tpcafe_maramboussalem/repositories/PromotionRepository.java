package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // 1. Pourcentage exact
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo = :pourcentage", nativeQuery = true)
    List<Promotion> findByPourcentageExact(int pourcentage);

    // 2. Par date début
    @Query(value = "SELECT * FROM promotion WHERE date_debut_promo = :date", nativeQuery = true)
    List<Promotion> findByDateDebut(LocalDate date);

    // 3. Par date fin
    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo = :date", nativeQuery = true)
    List<Promotion> findByDateFin(LocalDate date);

    // 4. Exists par pourcentage
    @Query(value = "SELECT COUNT(*) > 0 FROM promotion WHERE pourcentage_promo = :pourcentage", nativeQuery = true)
    boolean existsByPourcentage(int pourcentage);

    // 5. Compter promotions débutant après date
    @Query(value = "SELECT COUNT(*) FROM promotion WHERE date_debut_promo > :date", nativeQuery = true)
    long countByDateDebutAfter(LocalDate date);

    // 6. Promotions actives à une date donnée
    @Query(value = "SELECT * FROM promotion " + "WHERE date_debut_promo <= :date AND (date_fin_promo IS NULL OR date_fin_promo >= :date)", nativeQuery = true)
    List<Promotion> findActiveAt(LocalDate date);

    // 7. Pourcentage spécifique débutant dans période
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo = :p AND date_debut_promo BETWEEN :d1 AND :d2", nativeQuery = true)
    List<Promotion> findByPourcentageInPeriod(int p, LocalDate d1, LocalDate d2);

    // 8. Promotions valides à une date
    @Query(value = "SELECT * FROM promotion WHERE date_debut_promo <= :date AND date_fin_promo >= :date", nativeQuery = true)
    List<Promotion> findValidAt(LocalDate date);

    // 9. Triées par % dans liste
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo IN (:list) ORDER BY date_debut_promo", nativeQuery = true)
    List<Promotion> findByPourcentages(List<Integer> list);

    // 10. Promotions actives triées par pourcentage
    @Query(value = "SELECT * FROM promotion " + "WHERE date_fin_promo IS NULL OR date_fin_promo >= CURRENT_DATE " + "ORDER BY pourcentage_promo", nativeQuery = true)
    List<Promotion> findActiveOrderedByPourcentage();

    // 11. Date fin NULL
    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo IS NULL", nativeQuery = true)
    List<Promotion> findWithoutEndDate();

    // 12. Pourcentage non null
    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo IS NOT NULL", nativeQuery = true)
    List<Promotion> findPourcentageNotNull();

    // 13. Promotions avec articles
    @Query(value = "SELECT * FROM promotion p " + "JOIN article_promotion ap ON p.id = ap.promotion_id", nativeQuery = true)
    List<Promotion> findWithArticles();

    // 14. Promotions expirées
    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo < CURRENT_DATE", nativeQuery = true)
    List<Promotion> findExpired();
}
