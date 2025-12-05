package tn.esprit.spring.tpcafe_maramboussalem.dto.Promotion;

import lombok.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Article.ArticleResponse;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionResponse {
     private long idPromotion;
     private String pourcentagePromo;
     private LocalDate dateDebutPromo;
     private LocalDate dateFinPromo;

     private List<ArticleResponse> articles;
}
