package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;

@Mapper(componentModel = "spring")
public interface AdresseMapper {

    Adresse toEntity(AdresseRequest dto);
    AdresseResponse toDto(Adresse adresse);

}
