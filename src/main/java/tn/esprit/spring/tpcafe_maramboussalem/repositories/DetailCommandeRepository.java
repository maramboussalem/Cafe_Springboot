package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;

public interface Detail_CommandeRepository extends JpaRepository<DetailCommande, Integer> {
}
