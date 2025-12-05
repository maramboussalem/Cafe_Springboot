package tn.esprit.spring.tpcafe_maramboussalem.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CarteFidelite")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarteFidelite  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCarteFidelite;

    int pointsAccumules;
    LocalDate dateCreation;

    @ManyToOne
    Client client;

}