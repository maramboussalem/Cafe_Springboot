package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Adresse")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAdresse;

    String rue;
    String ville;
    int codePostal;

    @OneToOne(mappedBy = "adresse")
    Client client;
}
