package tn.esprit.spring.tpcafe_maramboussalem.services.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ClientRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    public ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> saveClient(List<Client> Clients) {
         return clientRepository.saveAll(Clients);
    }

    @Override
    public Client selectClientById(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> selectAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Client Clients) {
         clientRepository.delete(Clients);
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

    @Override
    public Client selectClientByIdWithOrElse(long id) {
        Client client = Client.builder()
                .nom("Maram").prenom("Boussalem").dateNaissance(LocalDate.now())
                .build();
        return clientRepository.findById(id).orElse(client);
    }

    @Override
    public Client selectClientByIdWithGet(long id) {
        return clientRepository.findById(id).get();
    }
}
