package tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresseResponse {
     private long idAdresse;
     private String rue;
     private String ville;
     private int codePostal;
}
