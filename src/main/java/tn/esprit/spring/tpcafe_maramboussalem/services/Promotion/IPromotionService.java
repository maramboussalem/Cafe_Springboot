package tn.esprit.spring.tpcafe_maramboussalem.services.Promotion;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;

import java.util.List;

public interface IPromotionService {

    Promotion addPromotion(Promotion promotion);
    List<Promotion> savePromotions(List<Promotion> promotions);
    Promotion selectPromotionById(long id);
    List<Promotion>selectAllPromotions();
    void deletePromotion(Promotion promotion);
    void deleteAllPromotions();
    void deletePromotionById(long id);
    long countPromotions();
    boolean verifPromotionById(long id);
    Promotion selectPromotionByIdWithOrElse(long id) ;
    Promotion selectPromotionByIdWithGet(long id) ;
}
