package tn.esprit.spring.tpcafe_maramboussalem.services.DetailCommande;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.DetailCommandeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailCommandeService implements IDetailCommandeService {

    public DetailCommandeRepository detailCommandeRepository;

    @Override
    public DetailCommande addDetailCommande(DetailCommande detailCommande) {
        return detailCommandeRepository.save(detailCommande);
    }

    @Override
    public List<DetailCommande> saveDetailCommande(List<DetailCommande> detailCommandes) {
        return detailCommandeRepository.saveAll(detailCommandes);
    }

    @Override
    public DetailCommande selectDetailCommandeById(long id) {
        return detailCommandeRepository.findById(id).get();
    }

    @Override
    public List<DetailCommande> selectAllDetailCommande() {
        return detailCommandeRepository.findAll();
    }

    @Override
    public void deleteDetailCommande(DetailCommande detailCommande) {
          detailCommandeRepository.delete(detailCommande);
    }

    @Override
    public void deleteAllDetailCommande() {
         detailCommandeRepository.deleteAll();
    }

    @Override
    public void deleteDetailCommandeById(long id) {
         detailCommandeRepository.deleteById(id);
    }

    @Override
    public long countDetailCommande() {
        return detailCommandeRepository.count();
    }

    @Override
    public boolean verifDetailCommandeById(long id) {
        return detailCommandeRepository.existsById(id);
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithOrElse(long id) {
        DetailCommande detailCommande = DetailCommande.builder()
                .quantiteArticle(100)
                .sousTotalDetailArticle(120)
                .sousTotalDetailArticleApresPromo(140)
                .build();
        return detailCommandeRepository.findById(id).orElse(detailCommande);
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithGet(long id) {
        return detailCommandeRepository.findById(id).get();
    }
}
