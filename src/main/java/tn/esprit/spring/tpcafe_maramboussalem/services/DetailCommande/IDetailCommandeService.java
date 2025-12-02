package tn.esprit.spring.tpcafe_maramboussalem.services.DetailCommande;

import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;

import java.util.List;

public interface IDetailCommandeService {
    DetailCommandeResponse addDetailCommande(DetailCommandeRequest detailCommandeRequest);

    DetailCommandeResponse selectDetailCommandeById(long id);
    List<DetailCommandeResponse> selectAllDetailCommande();

    DetailCommandeResponse updateDetailCommande(long id,DetailCommandeRequest detailCommandeRequest);

    void deleteAllDetailCommande();
    void deleteDetailCommandeById(long id);

    long countDetailCommande();
    boolean verifDetailCommandeById(long id);
}
