package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;
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

}
