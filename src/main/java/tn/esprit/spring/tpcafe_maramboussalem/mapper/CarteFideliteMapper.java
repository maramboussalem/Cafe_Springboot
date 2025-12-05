package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;

@Mapper(componentModel = "spring")
public interface CarteFideliteMapper {

    CarteFidelite toEntity(CarteFideliteRequest dto);
    CarteFideliteResponse toDto(CarteFidelite carteFidelite);

}