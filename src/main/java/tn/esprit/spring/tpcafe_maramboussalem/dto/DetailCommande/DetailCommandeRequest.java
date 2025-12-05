package tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCommandeRequest {

    private int quantiteArticle;
    private float sousTotalDetailArticle;
    private float sousTotalDetailArticleApresPromo;

    private Long articleId;
    private Long commandeId;

}