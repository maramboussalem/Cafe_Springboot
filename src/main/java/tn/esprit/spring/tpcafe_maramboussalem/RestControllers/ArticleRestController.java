package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Promotion;
import tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle;
import tn.esprit.spring.tpcafe_maramboussalem.services.Article.IArticleService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("article")
@Tag(name = "Article", description = "Gestion des Articles")
public class ArticleRestController {

    private IArticleService articleService;

    @PostMapping("/addArticle")
    public ArticleResponse addArticle(@RequestBody ArticleRequest articleRequest) {
        return articleService.addArticle(articleRequest);
    }

    @GetMapping("/getArticleById/{id}")
    public ArticleResponse getArticleById(@PathVariable long id) {
        return articleService.selectArticleById(id);
    }

    @GetMapping("/getAllArticles")
    public List<ArticleResponse> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/existsArticle/{id}")
    public boolean existsArticle(@PathVariable long id) {
        return articleService.verifArticleById(id);
    }

    @GetMapping("/countArticles")
    public long countArticles() {
        return articleService.countArticles();
    }

    @PutMapping("/updateArticle/{id}")
    public ArticleResponse updateArticle(@PathVariable long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.updateArticle(id, articleRequest);
    }

    @DeleteMapping("/deleteArticleById/{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.deleteArticleById(id);
    }

    @DeleteMapping("/deleteAllArticles")
    public void deleteAllArticles() {
        articleService.deleteAllArticles();
    }

    // -------------------- FIND METHODS --------------------

    @GetMapping("/findByNom")
    public List<ArticleResponse> findByNom(@RequestParam String nom) {
        return articleService.findByNom(nom);
    }

    @GetMapping("/findByType")
    public List<ArticleResponse> findByType(@RequestParam TypeArticle type) {
        return articleService.findByType(type);
    }

    @GetMapping("/findByPrix")
    public List<ArticleResponse> findByPrix(@RequestParam float prix) {
        return articleService.findByPrix(prix);
    }

    @GetMapping("/existsByNom")
    public boolean existsByNom(@RequestParam String nom) {
        return articleService.existsByNom(nom);
    }

    @GetMapping("/countByType")
    public long countByType(@RequestParam TypeArticle type) {
        return articleService.countByType(type);
    }

    @GetMapping("/findByNomContainingAndType")
    public List<ArticleResponse> findByNomContainingAndType(
            @RequestParam String nom,
            @RequestParam TypeArticle type) {
        return articleService.findByNomContainingAndType(nom, type);
    }

    @GetMapping("/findByPrixBetweenAndType")
    public List<ArticleResponse> findByPrixBetweenAndType(
            @RequestParam float min,
            @RequestParam float max,
            @RequestParam TypeArticle type) {
        return articleService.findByPrixBetweenAndType(min, max, type);
    }

    @GetMapping("/findByNomStartsWithSortedByPrix")
    public List<ArticleResponse> findByNomStartsWithSortedByPrix(@RequestParam String prefix) {
        return articleService.findByNomStartsWithSortedByPrix(prefix);
    }

    @GetMapping("/findMaxPriceByType")
    public List<ArticleResponse> findMaxPriceByType(@RequestParam TypeArticle type) {
        return articleService.findMaxPriceByType(type);
    }

    @GetMapping("/findByNomOrTypeOrderByPrixDesc")
    public List<ArticleResponse> findByNomOrTypeOrderByPrixDesc(
            @RequestParam String nom,
            @RequestParam TypeArticle type) {
        return articleService.findByNomOrTypeOrderByPrixDesc(nom, type);
    }

    @GetMapping("/findByNomStartsWith")
    public List<ArticleResponse> findByNomStartsWith(@RequestParam String prefix) {
        return articleService.findByNomStartsWith(prefix);
    }

    @GetMapping("/findByNomEndsWith")
    public List<ArticleResponse> findByNomEndsWith(@RequestParam String suffix) {
        return articleService.findByNomEndsWith(suffix);
    }

    @GetMapping("/findByTypeIsNull")
    public List<ArticleResponse> findByTypeIsNull() {
        return articleService.findByTypeIsNull();
    }

    @GetMapping("/findByPrixNotNull")
    public List<ArticleResponse> findByPrixNotNull() {
        return articleService.findByPrixNotNull();
    }

    @GetMapping("/findWithActivePromotions")
    public List<ArticleResponse> findWithActivePromotions() {
        return articleService.findWithActivePromotions();
    }

    @GetMapping("/findByNomContainingAndPrixBetween")
    public List<ArticleResponse> findByNomContainingAndPrixBetween(
            @RequestParam String nom,
            @RequestParam float min,
            @RequestParam float max) {
        return articleService.findByNomContainingAndPrixBetween(nom, min, max);
    }

    // -------------------- PROMOTIONS --------------------

    @PostMapping("/addWithPromos")
    public Article addWithPromos(@RequestBody Article article) {
        return articleService.ajouterArticleEtPromotions(article);
    }

    @PostMapping("/addPromoToArticle/{idArticle}")
    public void addPromoToArticle(@RequestBody Promotion promo, @PathVariable long idArticle) {
        articleService.ajouterPromoEtAffecterAArticle(promo, idArticle);
    }
}
