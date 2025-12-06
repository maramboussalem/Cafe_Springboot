package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;

import java.util.List;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Long> {
    @Query(value = "SELECT * FROM detail_commande WHERE quantite = :qty", nativeQuery = true)
    List<DetailCommande> findByQuantiteExact(int qty);

    @Query(value = "SELECT * FROM detail_commande WHERE sous_total = :st", nativeQuery = true)
    List<DetailCommande> findBySousTotalExact(float st);

    @Query(value = "SELECT COUNT(*) FROM detail_commande WHERE quantite > :qty", nativeQuery = true)
    long countQuantityGreater(int qty);

    @Query(value = "SELECT COUNT(*) > 0 FROM detail_commande WHERE sous_total > :st", nativeQuery = true)
    boolean existsBySousTotalGreater(float st);

    @Query(value = "SELECT * FROM detail_commande WHERE quantite BETWEEN :min AND :max AND sous_total >= :stMin", nativeQuery = true)
    List<DetailCommande> findByQuantiteRangeAndSousTotal(int min, int max, float stMin);

    @Query(value = "SELECT * FROM detail_commande WHERE sous_total BETWEEN :min AND :max ORDER BY quantite", nativeQuery = true)
    List<DetailCommande> findBySousTotalRangeOrderByQty(float min, float max);

    @Query(value = "SELECT * FROM detail_commande WHERE sous_total_apres_promo BETWEEN :min AND :max", nativeQuery = true)
    List<DetailCommande> findBySousTotalPromoRange(float min, float max);

    @Query(value = "SELECT * FROM detail_commande WHERE quantite >= :qty OR sous_total >= :st", nativeQuery = true)
    List<DetailCommande> findByQtyOrSousTotalMin(int qty, float st);

    @Query(value = "SELECT * FROM detail_commande ORDER BY sous_total DESC LIMIT 5", nativeQuery = true)
    List<DetailCommande> findTop5Expensive();

    @Query(value = "SELECT * FROM detail_commande WHERE quantite IS NULL", nativeQuery = true)
    List<DetailCommande> findQuantityNull();

    @Query(value = "SELECT * FROM detail_commande WHERE sous_total_apres_promo IS NOT NULL", nativeQuery = true)
    List<DetailCommande> findSousTotalPromoNotNull();

    @Query(value = "SELECT * FROM detail_commande dc " + "JOIN commande c ON c.id_commande = dc.commande_id " + "JOIN article a ON a.id_article = dc.article_id", nativeQuery = true)
    List<DetailCommande> findWithCommandeAndArticle();
}
