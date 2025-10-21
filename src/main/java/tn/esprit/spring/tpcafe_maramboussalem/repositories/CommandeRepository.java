package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
