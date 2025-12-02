package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    // DTO → Entité
    Adresse toEntity(AdresseRequest dto);
    // Entité → DTO
    AdresseResponse toDto(Adresse adresse);
}
