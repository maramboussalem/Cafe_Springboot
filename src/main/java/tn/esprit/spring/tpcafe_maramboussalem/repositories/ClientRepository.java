package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle;
import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByNom(String nom);
    List<Client> findByPrenom(String prenom);
    Client findByNomAndPrenom(String nom, String prenom);
    boolean existsByNom(String nom);
    long countByDateNaissanceAfter(LocalDate date);
    List<Client> findByNomContainingOrPrenomContaining(String nomPart, String prenomPart);

    // 7. Nom ET prénom contiennent
    List<Client> findByNomContainingAndPrenomContaining(String nomPart, String prenomPart);
    // 8. Nés entre deux dates
    List<Client> findByDateNaissanceBetween(LocalDate d1, LocalDate d2);
    // 9. Nom commence par ET né avant date
    List<Client> findByNomStartsWithAndDateNaissanceBefore(String prefix, LocalDate date);
    // 10. Par ville (jointure implicite)
    List<Client> findByAdresseVille(String ville);
    // 11. Nom contient, trié par prénom ASC
    List<Client> findByNomContainingOrderByPrenomAsc(String nomPart);
    // 12. Nom contient, trié par prénom DESC
    List<Client> findByNomContainingOrderByPrenomDesc(String nomPart);
    // 13. Nom commence par
    List<Client> findByNomStartsWith(String prefix);
    // 14. Prénom finit par
    List<Client> findByPrenomEndsWith(String suffix);
    // 15. Date naissance NULL
    List<Client> findByDateNaissanceIsNull();
    // 16. Adresse NOT NULL
    List<Client> findByAdresseIsNotNull();
    // 17. Clients de plusieurs villes
    List<Client> findByAdresseVilleIn(List<String> villes);


    // 18. Points > valeur
    @Query("SELECT c FROM Client c WHERE c.carteFidelite.pointsAccumules > :pts")
    List<Client> findClientsWithCartePointsGreaterThan(@Param("pts") int pts);

    // 19. Points >= valeur
    @Query("SELECT c FROM Client c WHERE c.carteFidelite.pointsAccumules >= :pts")
    List<Client> findClientsWithCartePointsGreaterOrEqual(@Param("pts") int pts);

    // 20. Points entre min et max
    @Query("SELECT c FROM Client c WHERE c.carteFidelite.pointsAccumules BETWEEN :min AND :max")
    List<Client> findClientsWithCartePointsBetween(@Param("min") int min, @Param("max") int max);

    // 21. Clients ayant commandé un article par nom
    @Query("SELECT DISTINCT c FROM Client c " + "JOIN c.commandes cmd " + "JOIN cmd.details d " + "JOIN d.article a " + "WHERE a.nomArticle = :nom")
    List<Client> findClientsWhoOrderedArticleNamed(@Param("nom") String nom);

    // 22. Nom contient + type article commandé
    @Query("SELECT DISTINCT c FROM Client c " + "JOIN c.commandes cmd " + "JOIN cmd.details d " + "JOIN d.article a " + "WHERE (c.nom LIKE %:str% OR c.prenom LIKE %:str%) " + "AND a.typeArticle = :type")
    List<Client> findClientsWithNameContainingAndOrderedArticleType(@Param("str") String str, @Param("type") TypeArticle type);
}