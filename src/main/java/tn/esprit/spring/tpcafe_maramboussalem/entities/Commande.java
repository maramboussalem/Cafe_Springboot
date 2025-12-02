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
@Table(name = "Commande")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Commande  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCommande;

    LocalDate dateCommande;
    float totalCommande;

    @Enumerated(EnumType.STRING)
    StatusCommande statusCommande;

    @ManyToOne
    Client client;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    List<DetailCommande> details;
}
