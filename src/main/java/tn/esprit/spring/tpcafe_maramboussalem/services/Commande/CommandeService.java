package tn.esprit.spring.tpcafe_maramboussalem.services.Commande;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CommandeRepository;

import java.time.LocalDate;
import java.util.List;

import static tn.esprit.spring.tpcafe_maramboussalem.entities.StatusCommande.EN_COURS;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {

    public CommandeRepository commandeRepository;

    @Override
    public Commande addCommande(Commande commandes) {
        return commandeRepository.save(commandes);
    }

    @Override
    public List<Commande> saveCommande(List<Commande> Commandes) {
        return commandeRepository.saveAll(Commandes);
    }

    @Override
    public Commande selectCommandeById(long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public List<Commande> selectAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public void deleteCommande(Commande Commandes) {
       commandeRepository.delete(Commandes);
    }

    @Override
    public void deleteAllCommande() {
         commandeRepository.deleteAll();
    }

    @Override
    public void deleteCommandeById(long id) {
       commandeRepository.deleteById(id);
    }

    @Override
    public long countCommande() {
        return commandeRepository.count();
    }

    @Override
    public boolean verifCommandeById(long id) {
        return commandeRepository.existsById(id);
    }

    @Override
    public Commande selectCommandeByIdWithOrElse(long id) {
        Commande commande = Commande.builder()
                .dateCommande(LocalDate.now())
                .totalCommande(1000)
                .statusCommande(EN_COURS).build();
        return commandeRepository.findById(id).get();
    }

    @Override
    public Commande selectCommandeByIdWithGet(long id) {
        return commandeRepository.findById(id).get();
    }
}
