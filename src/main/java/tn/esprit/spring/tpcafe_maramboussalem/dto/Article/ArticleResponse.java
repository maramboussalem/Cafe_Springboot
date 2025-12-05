package tn.esprit.spring.tpcafe_maramboussalem.dto.Article;

import lombok.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion.PromotionResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {

     private long idArticle;
     private String nomArticle;
     private float prixArticle;
     private TypeArticle typeArticle;

     private List<PromotionResponse> promotions;
     private List<DetailCommandeResponse> detailCommandes;
}