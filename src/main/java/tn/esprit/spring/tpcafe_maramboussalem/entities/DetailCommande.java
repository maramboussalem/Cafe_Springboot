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
@Table(name = "Detail_Commande")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idDetail_Commande;

    int quantiteArticle;
    float sousTotalDetailArticle;
    float sousTotalDetailArticleApresPromo;

    @ManyToOne
    Commande commande;

    @ManyToOne
    Article article;

}
