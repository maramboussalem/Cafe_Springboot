package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Client")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Client {
    @OneToOne CarteFidelite carte;
    @OneToOne Adresse adresse;
    @OneToMany (mappedBy = "client") List <Commande> commandes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;


}
