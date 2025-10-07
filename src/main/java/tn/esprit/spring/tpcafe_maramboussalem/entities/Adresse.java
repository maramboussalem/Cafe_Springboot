package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Adresse")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdresse;

    private String rue;
    private String ville;
    private int codePostal;

}
