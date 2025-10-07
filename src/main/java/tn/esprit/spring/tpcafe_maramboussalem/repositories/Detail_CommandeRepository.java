package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Detail_Commande;

public interface Detail_CommandeRepository extends JpaRepository<Detail_Commande, Integer> {
}
