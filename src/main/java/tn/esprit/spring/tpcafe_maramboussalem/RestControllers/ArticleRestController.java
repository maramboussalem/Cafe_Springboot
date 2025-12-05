package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle;
import tn.esprit.spring.tpcafe_maramboussalem.services.Article.IArticleService;

import java.util.List;

@RestController
@RequestMapping("article")
@Tag(name = "Article", description = "Gestion des Articles")
@AllArgsConstructor
public class ArticleRestController {

    private final IArticleService articleService;

    @PostMapping
    public ArticleResponse addArticle(@RequestBody ArticleRequest articleRequest) {
        return articleService.addArticle(articleRequest);
    }

    @GetMapping("{id}")
    public ArticleResponse getArticleById(@PathVariable long id) {
        return articleService.selectArticleById(id);
    }

    @GetMapping
    public List<ArticleResponse> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/exists/{id}")
    public boolean existsArticle(@PathVariable long id) {
        return articleService.verifArticleById(id);
    }

    @GetMapping("/count")
    public long countArticles() {
        return articleService.countArticles();
    }

    @PutMapping("{id}")
    public ArticleResponse updateArticle(@PathVariable long id, @RequestBody ArticleRequest articleRequest) {
        return articleService.updateArticle(id, articleRequest);
    }

    @DeleteMapping("{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.deleteArticleById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllArticles() {
        articleService.deleteAllArticles();
    }

    // 1. Nom exact
    @GetMapping("/by-nom")
    public List<ArticleResponse> findByNom(@RequestParam String nom) {
        return articleService.findByNom(nom);
    }

    // 2. Par type
    @GetMapping("/by-type")
    public List<ArticleResponse> findByType(@RequestParam TypeArticle type) {
        return articleService.findByType(type);
    }

    // 3. Par prix exact
    @GetMapping("/by-prix")
    public List<ArticleResponse> findByPrix(@RequestParam float prix) {
        return articleService.findByPrix(prix);
    }

    // 4. Existence par nom
    @GetMapping("/exists-by-nom")
    public boolean existsByNom(@RequestParam String nom) {
        return articleService.existsByNom(nom);
    }

    // 5. Compter par type
    @GetMapping("/count-by-type")
    public long countByType(@RequestParam TypeArticle type) {
        return articleService.countByType(type);
    }

    // 6. Nom contient + type
    @GetMapping("/search-by-nom-type")
    public List<ArticleResponse> findByNomContainingAndType(@RequestParam String nom,
                                                            @RequestParam TypeArticle type) {
        return articleService.findByNomContainingAndType(nom, type);
    }

    // 7. Prix dans plage + type
    @GetMapping("/search-by-prix-type")
    public List<ArticleResponse> findByPrixBetweenAndType(@RequestParam float min,
                                                          @RequestParam float max,
                                                          @RequestParam TypeArticle type) {
        return articleService.findByPrixBetweenAndType(min, max, type);
    }

    // 8. Nom commence par (ignore case), tri prix asc
    @GetMapping("/starts-with")
    public List<ArticleResponse> findByNomStartsWithSortedByPrix(@RequestParam String prefix) {
        return articleService.findByNomStartsWithSortedByPrix(prefix);
    }

    // 9. Prix max par type
    @GetMapping("/max-prix-by-type")
    public List<ArticleResponse> findMaxPriceByType(@RequestParam TypeArticle type) {
        return articleService.findMaxPriceByType(type);
    }

    // 10. Nom ou type, tri prix desc
    @GetMapping("/by-nom-or-type")
    public List<ArticleResponse> findByNomOrTypeOrderByPrixDesc(@RequestParam String nom,
                                                                @RequestParam TypeArticle type) {
        return articleService.findByNomOrTypeOrderByPrixDesc(nom, type);
    }

    // 11. Nom commence par
    @GetMapping("/nom-starts")
    public List<ArticleResponse> findByNomStartsWith(@RequestParam String prefix) {
        return articleService.findByNomStartsWith(prefix);
    }

    // 12. Nom se termine par
    @GetMapping("/nom-ends")
    public List<ArticleResponse> findByNomEndsWith(@RequestParam String suffix) {
        return articleService.findByNomEndsWith(suffix);
    }

    // 13. Sans type
    @GetMapping("/without-type")
    public List<ArticleResponse> findByTypeIsNull() {
        return articleService.findByTypeIsNull();
    }

    // 14. Avec prix
    @GetMapping("/with-prix")
    public List<ArticleResponse> findByPrixNotNull() {
        return articleService.findByPrixNotNull();
    }

    // 15. Promotions actives
    @GetMapping("/with-active-promotions")
    public List<ArticleResponse> findWithActivePromotions() {
        return articleService.findWithActivePromotions();
    }

    // 16. Nom contient + prix dans plage
    @GetMapping("/search-nom-prix")
    public List<ArticleResponse> findByNomContainingAndPrixBetween(@RequestParam String nom, @RequestParam float min, @RequestParam float max) {
        return articleService.findByNomContainingAndPrixBetween(nom, min, max);
    }


}
