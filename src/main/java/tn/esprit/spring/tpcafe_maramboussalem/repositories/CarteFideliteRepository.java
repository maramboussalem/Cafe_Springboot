package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;

import java.time.LocalDate;
import java.util.List;

public interface CarteFideliteRepository extends JpaRepository<CarteFidelite, Long> {

    List<CarteFidelite> findByPointsAccumules(int points);
    List<CarteFidelite> findByDateCreation(LocalDate date);
    long countByPointsAccumulesGreaterThan(int points);
    void deleteByDateCreationBefore(LocalDate date);
    List<CarteFidelite> findByPointsAccumulesBetweenAndDateCreationAfter(int min, int max, LocalDate date);
    List<CarteFidelite> findByPointsAccumulesGreaterThanEqualOrderByDateCreationAsc(int points);
    List<CarteFidelite> findByDateCreationBetween(LocalDate start, LocalDate end);

    @Query("SELECT c FROM CarteFidelite c WHERE c.pointsAccumules < :pts OR c.dateCreation < :date")
    List<CarteFidelite> findByPointsLessThanOrDateCreationBefore(@Param("pts") int points, @Param("date") LocalDate date);

    @Query("SELECT c FROM CarteFidelite c WHERE c.pointsAccumules = (SELECT MAX(c2.pointsAccumules) FROM CarteFidelite c2)")
    List<CarteFidelite> findCarteWithMaxPoints();

    List<CarteFidelite> findByDateCreationIsNull();
    List<CarteFidelite> findByPointsAccumulesIsNotNull();

    @Query("SELECT c FROM CarteFidelite c JOIN c.client cl WHERE cl.nom = :nom AND cl.prenom = :prenom")
    List<CarteFidelite> findByClientNomAndPrenom(@Param("nom") String nom, @Param("prenom") String prenom);

    @Query("SELECT c FROM CarteFidelite c ORDER BY c.pointsAccumules DESC")
    List<CarteFidelite> findTop5ByOrderByPointsAccumulesDesc();

}
