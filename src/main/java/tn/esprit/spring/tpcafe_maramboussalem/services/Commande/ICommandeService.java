package tn.esprit.spring.tpcafe_maramboussalem.services.Commande;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;

import java.util.List;

public interface ICommandeService {
    Commande addCommande(Commande commandes);
    List<Commande> saveCommande(List<Commande> Commandes);
    Commande selectCommandeById(long id);
    List<Commande> selectAllCommande();
    void deleteCommande(Commande Commandes);
    void deleteAllCommande();
    void deleteCommandeById(long id);
    long countCommande();
    boolean verifCommandeById(long id);
    Commande selectCommandeByIdWithOrElse(long id) ;
    Commande selectCommandeByIdWithGet(long id) ;
}

