package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientRequest dto);
    ClientResponse toDto(Client client);

}