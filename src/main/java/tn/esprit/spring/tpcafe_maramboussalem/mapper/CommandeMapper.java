package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;

@Mapper(componentModel = "spring")
public interface CommandeMapper {

    Commande toEntity(CommandeRequest dto);
    CommandeResponse toDto(Commande commande);
}