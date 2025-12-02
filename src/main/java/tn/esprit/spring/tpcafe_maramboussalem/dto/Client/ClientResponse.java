package tn.esprit.spring.tpcafe_maramboussalem.dto.Client;

import lombok.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeResponse;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {
     private long idClient;
     private String nom;
     private String prenom;
     private LocalDate dateNaissance;

     private CarteFideliteResponse carte;
     private AdresseResponse adresse;
     private List<CommandeResponse> commandes;
}
