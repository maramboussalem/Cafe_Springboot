package tn.esprit.spring.tpcafe_maramboussalem.services.Commande;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;

import java.time.LocalDate;
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

    List<CommandeResponse> findByStatus(String status);
    List<CommandeResponse> findByDate(LocalDate date);
    long countByStatus(String status);
    void deleteBefore(LocalDate date);
    List<CommandeResponse> findBetweenDatesAndStatus(LocalDate d1, LocalDate d2, String status);
    List<CommandeResponse> findTotalGreaterAndStatusNot(float montant, String status);
    List<CommandeResponse> findByStatuses(List<String> statuses);
    List<CommandeResponse> findBeforeDateTotalBetween(LocalDate date, float min, float max);
    List<CommandeResponse> findStatusEndsWith(String suffix);
    List<CommandeResponse> findStatusNull();
    List<CommandeResponse> findTotalNotNull();
    List<CommandeResponse> findWithDetailsAndClient();
    List<CommandeResponse> top3Recent();

    void affecterCommandeAClient(long idCommande, long idClient);
    void desaffecterClientDeCommande(long idClient, long idCommande);

}

