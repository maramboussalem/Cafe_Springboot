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
        List<Article> articles = articleRepository.findAllById(request.getArticleIds());
        promotion.setArticles(articles);

        // Optionnel : mettre à jour la relation inverse
        for (Article a : articles) {
            if (a.getPromotions() == null) a.setPromotions(new ArrayList<>());
            a.getPromotions().add(promotion);
        }

        Promotion saved = promotionRepository.save(promotion);
        return promotionMapper.toDto(saved);
    }


    @Override
    public PromotionResponse selectPromotionById(long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion introuvable: " + id));
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
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion introuvable: " + id));

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
}
