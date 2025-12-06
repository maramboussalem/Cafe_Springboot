package tn.esprit.spring.tpcafe_maramboussalem.services.Promotion;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;

import java.time.LocalDate;
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
    void affecterPromotionAArticle(long idArticle, long idPromo);
    void desaffecterPromotionDUnArticle(long idArticle, long idPromo);

    List<PromotionResponse> findByPourcentageExact(int p);
    List<PromotionResponse> findByDateDebut(LocalDate date);
    List<PromotionResponse> findByDateFin(LocalDate date);
    boolean existsByPourcentage(int p);
    long countDateDebutAfter(LocalDate date);
    List<PromotionResponse> findActiveAt(LocalDate date);
    List<PromotionResponse> findByPourcentageInPeriod(int p, LocalDate d1, LocalDate d2);
    List<PromotionResponse> findValidAt(LocalDate date);
    List<PromotionResponse> findByPourcentages(List<Integer> list);
    List<PromotionResponse> findActiveOrderedByPourcentage();
    List<PromotionResponse> findWithoutEndDate();
    List<PromotionResponse> findPourcentageNotNull();
    List<PromotionResponse> findWithArticles();
    List<PromotionResponse> findExpired();


    }

