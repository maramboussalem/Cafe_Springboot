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

    List<DetailCommandeResponse> findByQuantiteExact(int qty);
    List<DetailCommandeResponse> findBySousTotalExact(float st);
    long countQuantityGreater(int qty);
    boolean existsBySousTotalGreater(float st);
    List<DetailCommandeResponse> findByQuantiteRangeAndSousTotal(int min, int max, float stMin);
    List<DetailCommandeResponse> findBySousTotalRangeOrderByQty(float min, float max);
    List<DetailCommandeResponse> findBySousTotalPromoRange(float min, float max);
    List<DetailCommandeResponse> findByQtyOrSousTotalMin(int qty, float st);
    List<DetailCommandeResponse> top5Expensive();
    List<DetailCommandeResponse> findQuantityNull();
    List<DetailCommandeResponse> findSousTotalPromoNotNull();
    List<DetailCommandeResponse> findWithCommandeAndArticle();


}
