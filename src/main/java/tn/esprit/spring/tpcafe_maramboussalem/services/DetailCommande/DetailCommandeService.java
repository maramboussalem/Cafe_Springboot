package tn.esprit.spring.tpcafe_maramboussalem.services.DetailCommande;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Article;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.DetailCommandeMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ArticleRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CommandeRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.DetailCommandeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DetailCommandeService implements IDetailCommandeService {

    DetailCommandeRepository detailCommandeRepository;
    DetailCommandeMapper detailCommandeMapper;
    ArticleRepository articleRepository;
    CommandeRepository commandeRepository;

    @Override
    public DetailCommandeResponse addDetailCommande(DetailCommandeRequest request) {
        // Vérifier que les IDs existent
        Article article = articleRepository.findById(request.getArticleId())
                .orElseThrow(() -> new RuntimeException("Article introuvable : " + request.getArticleId()));

        Commande commande = commandeRepository.findById(request.getCommandeId())
                .orElseThrow(() -> new RuntimeException("Commande introuvable : " + request.getCommandeId()));

        DetailCommande detailCommande = detailCommandeMapper.toEntity(request);

        detailCommande.setArticle(article);
        detailCommande.setCommande(commande);

        DetailCommande saved = detailCommandeRepository.save(detailCommande);
        return detailCommandeMapper.toDto(saved);
    }



    @Override
    public DetailCommandeResponse selectDetailCommandeById(long id) {
        DetailCommande detail = detailCommandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detail commande introuvable : " + id));
        return detailCommandeMapper.toDto(detail);
    }

    @Override
    public List<DetailCommandeResponse> selectAllDetailCommande() {
        return detailCommandeRepository.findAll()
                .stream()
                .map(detailCommandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DetailCommandeResponse updateDetailCommande(long id, DetailCommandeRequest request) {
        DetailCommande detail = detailCommandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detail commande introuvable : " + id));

        detail.setQuantiteArticle(request.getQuantiteArticle());
        detail.setSousTotalDetailArticle(request.getSousTotalDetailArticle());
        detail.setSousTotalDetailArticleApresPromo(request.getSousTotalDetailArticleApresPromo());

        DetailCommande updated = detailCommandeRepository.save(detail);
        return detailCommandeMapper.toDto(updated);
    }

    @Override
    public void deleteDetailCommandeById(long id) {
        detailCommandeRepository.deleteById(id);
    }

    @Override
    public void deleteAllDetailCommande() {
        detailCommandeRepository.deleteAll();
    }

    @Override
    public long countDetailCommande() {
        return detailCommandeRepository.count();
    }

    @Override
    public boolean verifDetailCommandeById(long id) {
        return detailCommandeRepository.existsById(id);
    }
}
