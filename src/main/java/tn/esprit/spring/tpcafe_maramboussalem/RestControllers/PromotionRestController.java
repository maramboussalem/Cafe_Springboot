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


    @PutMapping("/{idPromo}/article/{idArticle}")
    public void affecterPromotionAArticle(@PathVariable long idArticle, @PathVariable long idPromo) {
        promotionService.affecterPromotionAArticle(idArticle, idPromo);
    }


    @PutMapping("/{idPromo}/remove-article/{idArticle}")
    public void desaffecterPromotionDUnArticle(@PathVariable long idArticle, @PathVariable long idPromo) {
        promotionService.desaffecterPromotionDUnArticle(idArticle, idPromo);
    }


    @GetMapping("/pourcentage/{p}")
    public List<PromotionResponse> getByPourcentageExact(@PathVariable int p) {
        return promotionService.findByPourcentageExact(p);
    }

    @GetMapping("/datedebut/{date}")
    public List<PromotionResponse> getByDateDebut(@PathVariable LocalDate date) {
        return promotionService.findByDateDebut(date);
    }

    @GetMapping("/datefin/{date}")
    public List<PromotionResponse> getByDateFin(@PathVariable LocalDate date) {
        return promotionService.findByDateFin(date);
    }

    @GetMapping("/exists/pourcentage/{p}")
    public boolean existsPourcentage(@PathVariable int p) {
        return promotionService.existsByPourcentage(p);
    }

    @GetMapping("/count/after/{date}")
    public long countDateAfter(@PathVariable LocalDate date) {
        return promotionService.countDateDebutAfter(date);
    }

    @GetMapping("/active/{date}")
    public List<PromotionResponse> getActiveAt(@PathVariable LocalDate date) {
        return promotionService.findActiveAt(date);
    }

    @GetMapping("/period")
    public List<PromotionResponse> getPercentInPeriod(@RequestParam int p, @RequestParam LocalDate d1, @RequestParam LocalDate d2) {
        return promotionService.findByPourcentageInPeriod(p, d1, d2);
    }

    @GetMapping("/valid/{date}")
    public List<PromotionResponse> getValidAt(@PathVariable LocalDate date) {
        return promotionService.findValidAt(date);
    }

    @GetMapping("/pourcentages")
    public List<PromotionResponse> getByPourcentages(@RequestParam List<Integer> list) {
        return promotionService.findByPourcentages(list);
    }

    @GetMapping("/active/order")
    public List<PromotionResponse> getActiveOrdered() {
        return promotionService.findActiveOrderedByPourcentage();
    }

    @GetMapping("/noend")
    public List<PromotionResponse> getWithoutEnd() {
        return promotionService.findWithoutEndDate();
    }

    @GetMapping("/pourcentage/notnull")
    public List<PromotionResponse> getPctNotNull() {
        return promotionService.findPourcentageNotNull();
    }

    @GetMapping("/withArticles")
    public List<PromotionResponse> getWithArticles() {
        return promotionService.findWithArticles();
    }

    @GetMapping("/expired")
    public List<PromotionResponse> getExpired() {
        return promotionService.findExpired();
    }

}
