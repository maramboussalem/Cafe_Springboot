package tn.esprit.spring.tpcafe_maramboussalem.services.Commande;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.CommandeMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ClientRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CommandeRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.DetailCommandeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommandeService implements ICommandeService {

    CommandeRepository commandeRepository;
    CommandeMapper commandeMapper;

    ClientRepository clientRepository;
    DetailCommandeRepository detailCommandeRepository;

    @Override
    public CommandeResponse addCommande(CommandeRequest request) {
        Commande commande = commandeMapper.toEntity(request);

        // Lier le client
        if (request.getClientId() != null) {
            Client client = clientRepository.findById(request.getClientId())
                    .orElseThrow(() -> new RuntimeException("Client introuvable : " + request.getClientId()));
            commande.setClient(client);
        }

        // Lier les détails de commande si fournis
        if (request.getDetailCommandeIds() != null && !request.getDetailCommandeIds().isEmpty()) {
            List<DetailCommande> details = detailCommandeRepository.findAllById(request.getDetailCommandeIds());
            commande.setDetailCommandes(details);
        }

        Commande saved = commandeRepository.save(commande);
        return commandeMapper.toDto(saved);
    }


    @Override
    public CommandeResponse selectCommandeById(long id) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable : " + id));
        return commandeMapper.toDto(commande);
    }

    @Override
    public List<CommandeResponse> selectAllCommande() {
        return commandeRepository.findAll()
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeResponse updateCommande(long id, CommandeRequest request) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable : " + id));
        commande.setDateCommande(request.getDateCommande());
        commande.setTotalCommande(request.getTotalCommande());
        commande.setStatusCommande(request.getStatusCommande());

        return commandeMapper.toDto(commandeRepository.save(commande));
    }

    @Override
    public void deleteCommandeById(long id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public void deleteAllCommande() {
        commandeRepository.deleteAll();
    }

    @Override
    public boolean verifCommandeById(long id) {
        return commandeRepository.existsById(id);
    }

    @Override
    public long countCommande() {
        return commandeRepository.count();
    }
}
