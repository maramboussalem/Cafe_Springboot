package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;
import tn.esprit.spring.tpcafe_maramboussalem.services.Promotion.IPromotionService;

import java.util.List;

@RestController
@RequestMapping("promotion")
@Tag(name = "Promotion", description = "Gestion des Promotions")
@AllArgsConstructor
public class PromotionRestController {

    private IPromotionService promotionService;

    @GetMapping
    public List<Promotion> selectAllPromotion() {
        return promotionService.selectAllPromotions();
    }
    @PostMapping
    public Promotion addPromotion(@RequestBody Promotion promotion) {
        return promotionService.addPromotion(promotion);
    }
    @PostMapping("addpromotion")
    public List<Promotion> addPromotion(@RequestBody List<Promotion> promotions) {
        return promotionService.savePromotions(promotions);
    }
    @GetMapping("selectById/{id}")
    public Promotion selectPromotionById(@PathVariable long id) {
        return promotionService.selectPromotionByIdWithGet(id);
    }
    @GetMapping("selectById2")
    public Promotion selectPromotionById2(@RequestParam long id) {
        return promotionService.selectPromotionByIdWithOrElse(id);
    }
    @DeleteMapping("deletebyid/{id}")
    public void deletePromotionById(@PathVariable long id) {
        promotionService.deletePromotionById(id);
    }
    @DeleteMapping("deleteAll")
    public void deleteAllPromotions() {
        promotionService.deleteAllPromotions();
    }
    @GetMapping("count")
    public long countPromotions() {
        return promotionService.countPromotions();
    }
    @GetMapping("exists/{id}")
    public boolean verifPromotionById(@PathVariable long id) {
        return promotionService.verifPromotionById(id);
    }
}
