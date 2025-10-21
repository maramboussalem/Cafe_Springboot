package tn.esprit.spring.tpcafe_maramboussalem.services.DetailCommande;

import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;

import java.util.List;

public interface IDetailCommandeService {
    DetailCommande addDetailCommande(DetailCommande detailCommande);
    List<DetailCommande> saveDetailCommande(List<DetailCommande> detailCommandes);
    DetailCommande selectDetailCommandeById(long id);
    List<DetailCommande> selectAllDetailCommande();
    void deleteDetailCommande(DetailCommande detailCommande);
    void deleteAllDetailCommande();
    void deleteDetailCommandeById(long id);
    long countDetailCommande();
    boolean verifDetailCommandeById(long id);
    DetailCommande selectDetailCommandeByIdWithOrElse(long id) ;
    DetailCommande selectDetailCommandeByIdWithGet(long id) ;
}
