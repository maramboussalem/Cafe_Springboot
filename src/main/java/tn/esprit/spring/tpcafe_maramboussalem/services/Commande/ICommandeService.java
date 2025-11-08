package tn.esprit.spring.tpcafe_maramboussalem.services.Commande;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;

import java.util.List;

public interface ICommandeService {
    CommandeResponse addCommande(CommandeRequest commandeRequest);

    CommandeResponse selectCommandeById(long id);
    List<CommandeResponse> selectAllCommande();

    CommandeResponse updateCommande(long id,CommandeRequest commandeRequest);

    void deleteAllCommande();
    void deleteCommandeById(long id);

    long countCommande();
    boolean verifCommandeById(long id);
}

