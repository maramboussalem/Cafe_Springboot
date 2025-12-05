package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query(value = "SELECT * FROM commande WHERE status_commande = :status", nativeQuery = true)
    List<Commande> findByStatusNative(String status);

    @Query(value = "SELECT * FROM commande WHERE date_commande = :date", nativeQuery = true)
    List<Commande> findByDateNative(LocalDate date);

    @Query(value = "SELECT count(*) FROM commande WHERE status_commande = :status", nativeQuery = true)
    long countByStatusNative(String status);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM commande WHERE date_commande < :date", nativeQuery = true)
    void deleteBeforeDate(LocalDate date);

    @Query(value = "SELECT * FROM commande WHERE date_commande BETWEEN :d1 AND :d2 AND status_commande = :status", nativeQuery = true)
    List<Commande> findBetweenDatesAndStatus(LocalDate d1, LocalDate d2, String status);

    @Query(value = "SELECT * FROM commande WHERE total_commande > :montant AND status_commande <> :status", nativeQuery = true)
    List<Commande> findTotalGreaterAndStatusNot(float montant, String status);

    @Query(value = "SELECT * FROM commande WHERE status_commande IN (:statuses) ORDER BY date_commande", nativeQuery = true)
    List<Commande> findByStatusesOrderByDate(List<String> statuses);

    @Query(value = "SELECT * FROM commande WHERE date_commande < :date AND total_commande BETWEEN :min AND :max", nativeQuery = true)
    List<Commande> findBeforeDateAndTotalBetween(LocalDate date, float min, float max);

    @Query(value = "SELECT * FROM commande WHERE status_commande LIKE %:suffix", nativeQuery = true)
    List<Commande> findStatusEndsWith(String suffix);

    @Query(value = "SELECT * FROM commande WHERE status_commande IS NULL", nativeQuery = true)
    List<Commande> findStatusNull();

    @Query(value = "SELECT * FROM commande WHERE total_commande IS NOT NULL", nativeQuery = true)
    List<Commande> findTotalNotNull();

    @Query(value = "SELECT * FROM commande c " + "JOIN detail_commande d ON c.id_commande = d.commande_id " + "JOIN client cl ON cl.id = c.client_id", nativeQuery = true)
    List<Commande> findWithDetailsAndClient();

    @Query(value = "SELECT * FROM commande ORDER BY date_commande DESC LIMIT 3", nativeQuery = true)
    List<Commande> findTop3Recent();

    List<Commande> findByDateCommande(LocalDate date);

}
