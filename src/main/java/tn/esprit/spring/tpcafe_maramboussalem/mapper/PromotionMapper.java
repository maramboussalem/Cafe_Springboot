package tn.esprit.spring.tpcafe_maramboussalem.mapper;

import org.mapstruct.Mapper;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;

@Mapper(componentModel = "spring")
public interface PromotionMapper {

    Promotion toEntity(PromotionRequest dto);
    PromotionResponse toDto(Promotion promotion);

}
