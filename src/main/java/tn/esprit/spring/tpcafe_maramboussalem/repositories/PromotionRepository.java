package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo = :pourcentage", nativeQuery = true)
    List<Promotion> findByPourcentageExact(int pourcentage);

    @Query(value = "SELECT * FROM promotion WHERE date_debut_promo = :date", nativeQuery = true)
    List<Promotion> findByDateDebut(LocalDate date);

    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo = :date", nativeQuery = true)
    List<Promotion> findByDateFin(LocalDate date);

    @Query(value = "SELECT COUNT(*) > 0 FROM promotion WHERE pourcentage_promo = :pourcentage", nativeQuery = true)
    boolean existsByPourcentage(int pourcentage);

    @Query(value = "SELECT COUNT(*) FROM promotion WHERE date_debut_promo > :date", nativeQuery = true)
    long countByDateDebutAfter(LocalDate date);

    @Query(value = "SELECT * FROM promotion " + "WHERE date_debut_promo <= :date AND (date_fin_promo IS NULL OR date_fin_promo >= :date)", nativeQuery = true)
    List<Promotion> findActiveAt(LocalDate date);

    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo = :p AND date_debut_promo BETWEEN :d1 AND :d2", nativeQuery = true)
    List<Promotion> findByPourcentageInPeriod(int p, LocalDate d1, LocalDate d2);

    @Query(value = "SELECT * FROM promotion WHERE date_debut_promo <= :date AND date_fin_promo >= :date", nativeQuery = true)
    List<Promotion> findValidAt(LocalDate date);

    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo IN (:list) ORDER BY date_debut_promo", nativeQuery = true)
    List<Promotion> findByPourcentages(List<Integer> list);

    @Query(value = "SELECT * FROM promotion " + "WHERE date_fin_promo IS NULL OR date_fin_promo >= CURRENT_DATE " + "ORDER BY pourcentage_promo", nativeQuery = true)
    List<Promotion> findActiveOrderedByPourcentage();

    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo IS NULL", nativeQuery = true)
    List<Promotion> findWithoutEndDate();

    @Query(value = "SELECT * FROM promotion WHERE pourcentage_promo IS NOT NULL", nativeQuery = true)
    List<Promotion> findPourcentageNotNull();

    @Query(value = "SELECT * FROM promotion p " + "JOIN article_promotion ap ON p.id = ap.promotion_id", nativeQuery = true)
    List<Promotion> findWithArticles();

    @Query(value = "SELECT * FROM promotion WHERE date_fin_promo < CURRENT_DATE", nativeQuery = true)
    List<Promotion> findExpired();
}
