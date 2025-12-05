package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Client")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClient;

    String nom;
    String prenom;
    LocalDate dateNaissance;

    @OneToOne(cascade = CascadeType.ALL)
    Adresse adresse;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<Commande> commandes;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<CarteFidelite> cartesFidelite;

}