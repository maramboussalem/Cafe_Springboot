package tn.esprit.spring.tpcafe_maramboussalem.services.Promotion;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.PromotionMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ArticleRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.PromotionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionService implements IPromotionService {
    PromotionRepository promotionRepository;
    PromotionMapper promotionMapper;
    ArticleRepository articleRepository;

    @Override
    public PromotionResponse addPromotion(PromotionRequest request) {
        Promotion promotion = promotionMapper.toEntity(request);
        promotionRepository.save(promotion);
        return promotionMapper.toDto(promotion);
    }

    @Override
    public PromotionResponse selectPromotionById(long id) {
        Promotion promotion = promotionRepository.findById(id).get();
        return promotionMapper.toDto(promotion);
    }

    @Override
    public List<PromotionResponse> selectAllPromotions() {
        return promotionRepository.findAll()
                .stream()
                .map(promotionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PromotionResponse updatePromotion(long id, PromotionRequest request) {
        Promotion promotion = promotionRepository.findById(id).get();
        promotion.setPourcentagePromo(request.getPourcentagePromo());
        promotion.setDateDebutPromo(request.getDateDebutPromo());
        promotion.setDateFinPromo(request.getDateFinPromo());

        Promotion updated = promotionRepository.save(promotion);
        return promotionMapper.toDto(updated);
    }

    @Override
    public void deleteAllPromotions() {
        promotionRepository.deleteAll();
    }

    @Override
    public void deletePromotionById(long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public long countPromotions() {
        return promotionRepository.count();
    }

    @Override
    public boolean verifPromotionById(long id) {
        return promotionRepository.existsById(id);
    }

    @Override
    public void affecterPromotionAArticle(long idArticle, long idPromo) {
        Article article = articleRepository.findById(idArticle).get();
        Promotion promotion = promotionRepository.findById(idPromo).get();
        article.getPromotions().add(promotion);
        articleRepository.save(article);
    }

    @Override
    public void desaffecterPromotionDUnArticle(long idArticle, long idPromo) {
        Article article = articleRepository.findById(idArticle).get();
        Promotion promotion = promotionRepository.findById(idPromo).get();
        article.getPromotions().remove(promotion);
        articleRepository.save(article);
    }

    @Override
    public List<PromotionResponse> findByPourcentageExact(int p) {
        return promotionRepository.findByPourcentageExact(p)
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findByDateDebut(LocalDate date) {
        return promotionRepository.findByDateDebut(date)
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findByDateFin(LocalDate date) {
        return promotionRepository.findByDateFin(date)
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public boolean existsByPourcentage(int p) {
        return promotionRepository.existsByPourcentage(p);
    }

    @Override
    public long countDateDebutAfter(LocalDate date) {
        return promotionRepository.countByDateDebutAfter(date);
    }

    @Override
    public List<PromotionResponse> findActiveAt(LocalDate date) {
        return promotionRepository.findActiveAt(date)
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findByPourcentageInPeriod(int p, LocalDate d1, LocalDate d2) {
        return promotionRepository.findByPourcentageInPeriod(p, d1, d2)
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findValidAt(LocalDate date) {
        return promotionRepository.findValidAt(date)
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findByPourcentages(List<Integer> list) {
        return promotionRepository.findByPourcentages(list)
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findActiveOrderedByPourcentage() {
        return promotionRepository.findActiveOrderedByPourcentage()
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findWithoutEndDate() {
        return promotionRepository.findWithoutEndDate()
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findPourcentageNotNull() {
        return promotionRepository.findPourcentageNotNull()
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findWithArticles() {
        return promotionRepository.findWithArticles()
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionResponse> findExpired() {
        return promotionRepository.findExpired()
                .stream().map(promotionMapper::toDto).collect(Collectors.toList());
    }
}
