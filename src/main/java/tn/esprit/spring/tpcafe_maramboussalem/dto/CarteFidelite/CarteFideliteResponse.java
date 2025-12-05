package tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarteFideliteResponse {
     private long idCarteFidelite;
     private int pointsAccumules;
     private LocalDate dateCreation;
}