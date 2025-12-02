package tn.esprit.spring.tpcafe_maramboussalem.services.Promotion;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;

import java.util.List;

public interface IPromotionService {

    PromotionResponse addPromotion(PromotionRequest promotionRequest);

    PromotionResponse selectPromotionById(long id);
    List<PromotionResponse> selectAllPromotions();

    PromotionResponse updatePromotion(long id, PromotionRequest promotionRequest);

    void deleteAllPromotions();
    void deletePromotionById(long id);

    long countPromotions();
    boolean verifPromotionById(long id);

}

