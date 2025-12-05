package tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdresseRequest {
     private String rue;
     private String ville;
     private int codePostal;

}