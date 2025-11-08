package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;

@Mapper(componentModel = "spring")
public interface DetailCommandeMapper {

    DetailCommande toEntity(DetailCommandeRequest dto);

    @Mapping(source = "article.idArticle", target = "articleId")
    @Mapping(source = "commande.idCommande", target = "commandeId")

    DetailCommandeResponse toDto(DetailCommande detailCommande);

}
