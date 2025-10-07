package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "CarteFidelite")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode

public class CarteFidelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarteFidelite;

    private int pointsAccumules;
    private LocalDate dateCreation;
}
