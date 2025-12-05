package tn.esprit.spring.tpcafe_maramboussalem.services.Client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.*;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.ClientMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    ClientRepository clientRepository;
    ClientMapper clientMapper;
    CarteFideliteRepository carteFideliteRepository;
    AdresseRepository adresseRepository;

    @Override
    public ClientResponse addClient(ClientRequest request) {
        Client client = clientMapper.toEntity(request);

        // ⚠️ Gérer les relations manuellement si IDs fournis
        if (request.getAdresseId() != null) {
            Adresse adresse = adresseRepository.findById(request.getAdresseId())
                    .orElseThrow(() -> new RuntimeException("Adresse introuvable"));
            client.setAdresse(adresse);
        }

        if (request.getCarteId() != null) {
            CarteFidelite carte = carteFideliteRepository.findById(request.getCarteId())
                    .orElseThrow(() -> new RuntimeException("Carte introuvable"));
            client.setCarteFidelite(carte);
        }

        Client saved = clientRepository.save(client);
        return clientMapper.toDto(saved);
    }

    @Override
    public ClientResponse selectClientById(long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable : " + id));
        return clientMapper.toDto(client);
    }

    @Override
    public List<ClientResponse> selectAllClient() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse updateClient(long id, ClientRequest request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable : " + id));

        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setDateNaissance(request.getDateNaissance());

        // ⚠️ Gérer les relations si modifiées
        if (request.getAdresseId() != null) {
            Adresse adresse = adresseRepository.findById(request.getAdresseId())
                    .orElseThrow(() -> new RuntimeException("Adresse introuvable"));
            client.setAdresse(adresse);
        }

        if (request.getCarteId() != null) {
            CarteFidelite carte = carteFideliteRepository.findById(request.getCarteId())
                    .orElseThrow(() -> new RuntimeException("Carte introuvable"));
            client.setCarteFidelite(carte);
        }

        Client updated = clientRepository.save(client);
        return clientMapper.toDto(updated);
    }

    @Override
    public void deleteAllClient() {
        clientRepository.deleteAll();
    }

    @Override
    public void deleteClientById(long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client introuvable : " + id);
        }
        clientRepository.deleteById(id);
    }

    @Override
    public long countClient() {
        return clientRepository.count();
    }

    @Override
    public boolean verifClientById(long id) {
        return clientRepository.existsById(id);
    }

    @Override
    public List<ClientResponse> saveClients(List<ClientRequest> requests) {
        List<Client> clients = requests.stream()
                .map(clientMapper::toEntity)
                .collect(Collectors.toList());
        return clientRepository.saveAll(clients).stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    // ========== Méthodes de recherche (KEYWORDS) ========== ✅

    @Override
    public List<ClientResponse> findByNom(String nom) {
        return clientRepository.findByNom(nom).stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findByPrenom(String prenom) {
        return clientRepository.findByPrenom(prenom).stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse findByNomAndPrenom(String nom, String prenom) {
        Client c = clientRepository.findByNomAndPrenom(nom, prenom);
        return c != null ? clientMapper.toDto(c) : null;
    }

    @Override
    public boolean existsByNom(String nom) {
        return clientRepository.existsByNom(nom);
    }

    @Override
    public long countBornAfter(LocalDate date) {
        return clientRepository.countByDateNaissanceAfter(date);
    }

    @Override
    public List<ClientResponse> findNomOrPrenomContains(String str) {
        return clientRepository.findByNomContainingOrPrenomContaining(str, str)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findNomAndPrenomContains(String str) {
        return clientRepository.findByNomContainingAndPrenomContaining(str, str)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> bornBetween(LocalDate d1, LocalDate d2) {
        return clientRepository.findByDateNaissanceBetween(d1, d2)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findNomStartsBeforeDate(String prefix, LocalDate date) {
        return clientRepository.findByNomStartsWithAndDateNaissanceBefore(prefix, date)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findByVille(String ville) {
        return clientRepository.findByAdresseVille(ville).stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findNomContainsOrderAsc(String str) {
        return clientRepository.findByNomContainingOrderByPrenomAsc(str)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findNomContainsOrderDesc(String str) {
        return clientRepository.findByNomContainingOrderByPrenomDesc(str)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findNomStartsWith(String prefix) {
        return clientRepository.findByNomStartsWith(prefix)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findPrenomEndsWith(String suffix) {
        return clientRepository.findByPrenomEndsWith(suffix)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findNoDateNaissance() {
        return clientRepository.findByDateNaissanceIsNull()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findAdresseNotNull() {
        return clientRepository.findByAdresseIsNotNull()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findByVilles(List<String> villes) {
        return clientRepository.findByAdresseVilleIn(villes)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<ClientResponse> findByPointsGreater(int pts) {
        return clientRepository.findClientsWithCartePointsGreaterThan(pts)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findByPointsGreaterOrEqual(int pts) {
        return clientRepository.findClientsWithCartePointsGreaterOrEqual(pts)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> findPointsBetween(int min, int max) {
        return clientRepository.findClientsWithCartePointsBetween(min, max)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> orderedArticle(String article) {
        return clientRepository.findClientsWhoOrderedArticleNamed(article)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientResponse> nameContainsAndOrderedType(String str, TypeArticle type) {
        return clientRepository.findClientsWithNameContainingAndOrderedArticleType(str, type)
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }
}