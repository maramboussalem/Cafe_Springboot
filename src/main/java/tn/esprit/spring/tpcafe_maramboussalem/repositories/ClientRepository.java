package tn.esprit.spring.tpcafe_maramboussalem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
