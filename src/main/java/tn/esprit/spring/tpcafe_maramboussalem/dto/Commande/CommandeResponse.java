package tn.esprit.spring.tpcafe_maramboussalem.dto.Commande;

import lombok.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.StatusCommande;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeResponse {
     private long idCommande;
     private LocalDate dateCommande;
     private float totalCommande;
     private StatusCommande statusCommande;

     private ClientResponse client;
     private List<DetailCommandeResponse> detailCommandes;
}
