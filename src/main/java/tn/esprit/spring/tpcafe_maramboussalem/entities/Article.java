package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Article")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Article  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idArticle;

    String nomArticle;
    float prixArticle;

    @Enumerated(EnumType.STRING)
    TypeArticle typeArticle;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    List<Promotion> promotions;

    @OneToMany(mappedBy = "article")
    List<DetailCommande> detailCommandes;

}