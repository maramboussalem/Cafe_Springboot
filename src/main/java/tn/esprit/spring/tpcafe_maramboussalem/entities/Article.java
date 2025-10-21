package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@Table(name = "Article")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Article {
    @ManyToMany List<Promotion> promotions;
    @OneToMany (mappedBy = "article") List<DetailCommande>detailCommandes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArticle;

    private String nomArticle;
    private float prixArticle;

    @Enumerated(EnumType.STRING)
    private TypeArticle typeArticle;
}
