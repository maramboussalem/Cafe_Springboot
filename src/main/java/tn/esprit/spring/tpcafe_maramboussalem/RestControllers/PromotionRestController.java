package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Promotion.IPromotionService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("promotion")
@Tag(name = "Promotion", description = "Gestion des Promotions")
@AllArgsConstructor
public class PromotionRestController {

    private IPromotionService promotionService;

    @PostMapping("/addPromotion")
    public PromotionResponse addPromotion(@RequestBody PromotionRequest promotionRequest) {
        return promotionService.addPromotion(promotionRequest);
    }

    @GetMapping("/getPromotion/{id}")
    public PromotionResponse getPromotion(@PathVariable long id) {
        return promotionService.selectPromotionById(id);
    }

    @GetMapping("/getAllPromotions")
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

    @PutMapping("/updatePromotion/{id}")
    public PromotionResponse updatePromotion(@PathVariable long id, @RequestBody PromotionRequest promotionRequest) {
        return promotionService.updatePromotion(id, promotionRequest);
    }

    @DeleteMapping("/deletePromotion/{id}")
    public void deletePromotion(@PathVariable long id) {
        promotionService.deletePromotionById(id);
    }

    @DeleteMapping("/deleteAllPromotions")
    public void deleteAll() {
        promotionService.deleteAllPromotions();
    }

    @GetMapping("/getByPourcentageExact/{p}")
    public List<PromotionResponse> getByPourcentageExact(@PathVariable int p) {
        return promotionService.findByPourcentageExact(p);
    }

    @GetMapping("/getByDateDebut/{date}")
    public List<PromotionResponse> getByDateDebut(@PathVariable LocalDate date) {
        return promotionService.findByDateDebut(date);
    }

    @GetMapping("/getByDateFin/{date}")
    public List<PromotionResponse> getByDateFin(@PathVariable LocalDate date) {
        return promotionService.findByDateFin(date);
    }

    @GetMapping("/existsPourcentage/{p}")
    public boolean existsPourcentage(@PathVariable int p) {
        return promotionService.existsByPourcentage(p);
    }

    @GetMapping("/countDateAfter/{date}")
    public long countDateAfter(@PathVariable LocalDate date) {
        return promotionService.countDateDebutAfter(date);
    }

    @GetMapping("/getActiveAt/{date}")
    public List<PromotionResponse> getActiveAt(@PathVariable LocalDate date) {
        return promotionService.findActiveAt(date);
    }

    @GetMapping("/getPercentInPeriod")
    public List<PromotionResponse> getPercentInPeriod(@RequestParam int p, @RequestParam LocalDate d1, @RequestParam LocalDate d2) {
        return promotionService.findByPourcentageInPeriod(p, d1, d2);
    }

    @GetMapping("/getValidAt/{date}")
    public List<PromotionResponse> getValidAt(@PathVariable LocalDate date) {
        return promotionService.findValidAt(date);
    }

    @GetMapping("/getByPourcentages")
    public List<PromotionResponse> getByPourcentages(@RequestParam List<Integer> list) {
        return promotionService.findByPourcentages(list);
    }

    @GetMapping("/getActiveOrdered")
    public List<PromotionResponse> getActiveOrdered() {
        return promotionService.findActiveOrderedByPourcentage();
    }

    @GetMapping("/getWithoutEnd")
    public List<PromotionResponse> getWithoutEnd() {
        return promotionService.findWithoutEndDate();
    }

    @GetMapping("/getPctNotNull")
    public List<PromotionResponse> getPctNotNull() {
        return promotionService.findPourcentageNotNull();
    }

    @GetMapping("/getWithArticles")
    public List<PromotionResponse> getWithArticles() {
        return promotionService.findWithArticles();
    }

    @GetMapping("/getExpired")
    public List<PromotionResponse> getExpired() {
        return promotionService.findExpired();
    }

    @PutMapping("/{idPromo}/affecterPromotionAArticle/{idArticle}")
    public void affecterPromotionAArticle(@PathVariable long idArticle, @PathVariable long idPromo) {
        promotionService.affecterPromotionAArticle(idArticle, idPromo);
    }

    @PutMapping("/{idPromo}/desaffecterPromotionDUnArticle/{idArticle}")
    public void desaffecterPromotionDUnArticle(@PathVariable long idArticle, @PathVariable long idPromo) {
        promotionService.desaffecterPromotionDUnArticle(idArticle, idPromo);
    }

}
