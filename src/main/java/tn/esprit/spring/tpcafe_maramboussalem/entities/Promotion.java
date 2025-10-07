package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Promotion")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class Promotion {

    @ManyToMany(mappedBy = "promotions")
    List<Article>articles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPromotion;

    private String pourcentagePromo;
    private LocalDate dateDebutPromo;
    private LocalDate dateFinPromo;

}
