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

import java.time.LocalDate;
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

    @Override
    public List<CommandeResponse> findByStatus(String status) {
        return commandeRepository.findByStatusNative(status)
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findByDate(LocalDate date) {
        return commandeRepository.findByDateNative(date)
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public long countByStatus(String status) {
        return commandeRepository.countByStatusNative(status);
    }

    @Override
    public void deleteBefore(LocalDate date) {
        commandeRepository.deleteBeforeDate(date);
    }

    @Override
    public List<CommandeResponse> findBetweenDatesAndStatus(LocalDate d1, LocalDate d2, String status) {
        return commandeRepository.findBetweenDatesAndStatus(d1, d2, status)
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findTotalGreaterAndStatusNot(float montant, String status) {
        return commandeRepository.findTotalGreaterAndStatusNot(montant, status)
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findByStatuses(List<String> statuses) {
        return commandeRepository.findByStatusesOrderByDate(statuses)
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findBeforeDateTotalBetween(LocalDate date, float min, float max) {
        return commandeRepository.findBeforeDateAndTotalBetween(date, min, max)
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findStatusEndsWith(String suffix) {
        return commandeRepository.findStatusEndsWith(suffix)
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findStatusNull() {
        return commandeRepository.findStatusNull()
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findTotalNotNull() {
        return commandeRepository.findTotalNotNull()
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> findWithDetailsAndClient() {
        return commandeRepository.findWithDetailsAndClient()
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandeResponse> top3Recent() {
        return commandeRepository.findTop3Recent()
                .stream()
                .map(commandeMapper::toDto)
                .collect(Collectors.toList());
    }

}
