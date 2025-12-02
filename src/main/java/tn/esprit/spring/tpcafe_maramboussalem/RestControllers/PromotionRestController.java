package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Promotion.IPromotionService;

import java.util.List;

@RestController
@RequestMapping("promotion")
@Tag(name = "Promotion", description = "Gestion des Promotions")
@AllArgsConstructor
public class PromotionRestController {

    private IPromotionService promotionService;

    @PostMapping
    public PromotionResponse addPromotion(@RequestBody PromotionRequest promotionRequest) {
        return promotionService.addPromotion(promotionRequest);
    }

    @GetMapping("/{id}")
    public PromotionResponse getPromotion(@PathVariable long id) {
        return promotionService.selectPromotionById(id);
    }

    @GetMapping
    public List<PromotionResponse> getAllPromotions() {
        return promotionService.selectAllPromotions();
    }

    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable long id) {
        return promotionService.verifPromotionById(id);
    }

    @GetMapping("/count")
    public long count() {
        return promotionService.countPromotions();
    }

    @PutMapping("/{id}")
    public PromotionResponse updatePromotion(@PathVariable long id, @RequestBody PromotionRequest promotionRequest) {
        return promotionService.updatePromotion(id, promotionRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable long id) {
        promotionService.deletePromotionById(id);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        promotionService.deleteAllPromotions();
    }

}
