package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name = "Detail_Commande")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Detail_Commande {

    @ManyToOne
    private Commande commande;
    @ManyToOne Article article;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetail_Commande;

    private int quantiteArticle;
    private float sousTotalDetailArticle;
    private float sousTotalDetailArticleApresPromo;

}
