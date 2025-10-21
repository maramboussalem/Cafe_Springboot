package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Commande")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Commande {
    @OneToMany (mappedBy = "commande") List<DetailCommande> detailCommandes;
    @ManyToOne private Client client;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCommande;

    private LocalDate dateCommande;
    private float totalCommande;

    @Enumerated(EnumType.STRING)
    private StatusCommande statusCommande;

}
