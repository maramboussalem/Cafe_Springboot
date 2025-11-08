package tn.esprit.spring.tpcafe_maramboussalem.services.Client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.ClientMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.AdresseRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CarteFideliteRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ClientRepository;

import java.util.ArrayList;
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
    public ClientResponse addClient(ClientRequest clientRequest) {
        Client client = clientMapper.toEntity(clientRequest);

        // Lier la carte si un ID est fourni
        if (clientRequest.getCarteId() != null) {
            CarteFidelite carte = carteFideliteRepository.findById(clientRequest.getCarteId())
                    .orElseThrow(() -> new RuntimeException("Carte fidélité introuvable : " + clientRequest.getCarteId()));
            client.setCarte(carte);
        }

        // Lier l'adresse si un ID est fourni
        if (clientRequest.getAdresseId() != null) {
            Adresse adresse = adresseRepository.findById(clientRequest.getAdresseId())
                    .orElseThrow(() -> new RuntimeException("Adresse introuvable : " + clientRequest.getAdresseId()));
            client.setAdresse(adresse);
        }

        // Initialiser la liste des commandes
        client.setCommandes(new ArrayList<>());

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
        Client updated = clientRepository.save(client);
        return clientMapper.toDto(updated);
    }

    @Override
    public void deleteAllClient() {
        clientRepository.deleteAll();
    }

    @Override
    public void deleteClientById(long id) {
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
}
