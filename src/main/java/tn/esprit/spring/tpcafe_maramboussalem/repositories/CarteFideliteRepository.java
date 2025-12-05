package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;

import java.time.LocalDate;
import java.util.List;

public interface CarteFideliteRepository extends JpaRepository<CarteFidelite, Long> {

    // 1. Trouver les cartes avec un nombre exact de points
    List<CarteFidelite> findByPointsAccumules(int points);

    // 2. Trouver les cartes créées à une date spécifique
    List<CarteFidelite> findByDateCreation(LocalDate date);

    // 3. Compter les cartes avec plus de X points
    long countByPointsAccumulesGreaterThan(int points);

    // 4. Supprimer les cartes créées avant une date
    void deleteByDateCreationBefore(LocalDate date);

    // 5. Trouver les cartes avec des points dans une plage, créées après une date
    List<CarteFidelite> findByPointsAccumulesBetweenAndDateCreationAfter(int min, int max, LocalDate date);

    // 6. Trouver les cartes avec au moins X points, triées par date de création
    List<CarteFidelite> findByPointsAccumulesGreaterThanEqualOrderByDateCreationAsc(int points);

    // 7. Trouver les cartes créées entre deux dates
    List<CarteFidelite> findByDateCreationBetween(LocalDate start, LocalDate end);

    // 8. Trouver les cartes avec peu de points OU créées avant une date
    @Query("SELECT c FROM CarteFidelite c WHERE c.pointsAccumules < :pts OR c.dateCreation < :date")
    List<CarteFidelite> findByPointsLessThanOrDateCreationBefore(@Param("pts") int points, @Param("date") LocalDate date);

    // 9. Trouver la carte avec le plus de points
    @Query("SELECT c FROM CarteFidelite c WHERE c.pointsAccumules = (SELECT MAX(c2.pointsAccumules) FROM CarteFidelite c2)")
    List<CarteFidelite> findCarteWithMaxPoints();

    // 10. Trouver les cartes sans date de création
    List<CarteFidelite> findByDateCreationIsNull();

    // 11. Trouver les cartes avec des points accumulés renseignés
    List<CarteFidelite> findByPointsAccumulesIsNotNull();

    // 12. Trouver les cartes avec leur client propriétaire par nom et prénom
    @Query("SELECT c FROM CarteFidelite c JOIN c.client cl WHERE cl.nom = :nom AND cl.prenom = :prenom")
    List<CarteFidelite> findByClientNomAndPrenom(@Param("nom") String nom, @Param("prenom") String prenom);

    // 13. Trouver top 5 des cartes avec le plus de points
    @Query("SELECT c FROM CarteFidelite c ORDER BY c.pointsAccumules DESC")
    List<CarteFidelite> findTop5ByOrderByPointsAccumulesDesc();

}
