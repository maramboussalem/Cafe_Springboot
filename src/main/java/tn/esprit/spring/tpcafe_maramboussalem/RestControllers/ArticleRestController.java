package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.services.Article.IArticleService;

import java.util.List;

@RestController
@RequestMapping("article")
@Tag(name = "Article", description = "Gestion des Articles")
@AllArgsConstructor
public class ArticleRestController {

    private IArticleService articleService;

    @GetMapping
    public List<Article> selectAllArticle() {
        return articleService.selectAllArticles();
    }
    @PostMapping
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }
    @PostMapping("addarticle")
    public List<Article> addArticle(@RequestBody List<Article> articles) {
        return articleService.saveArticles(articles);
    }
    @GetMapping("selectById/{id}")
    public Article selectArticleById(@PathVariable long id) {
        return articleService.selectArticleByIdWithGet(id);
    }
    //http://localhost:8088/article/selectById2?id=1
    @GetMapping("selectById2")
    public Article selectArticleById2(@RequestParam long id) {
        return articleService.selectArticleByIdWithOrElse(id);
    }

    @DeleteMapping("deletebyid/{id}")
    public void deleteArticleById(@PathVariable long id) {
        articleService.deleteArticleById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllArticle() {
        articleService.deleteAllArticles();
    }

    @GetMapping("count")
    public long countArticle() {
        return articleService.countArticles();
    }

    @GetMapping("exists/{id}")
    public boolean verifArticleById(@PathVariable long id) {
        return articleService.verifArticleById(id);
    }

}
