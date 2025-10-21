package tn.esprit.spring.tpcafe_maramboussalem.services.Client;

import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;

import java.util.List;

public interface IClientService {
    Client addClient(Client client);
    List<Client> saveClient(List<Client> Clients);
    Client selectClientById(long id);
    List<Client> selectAllClient();
    void deleteClient(Client Clients);
    void deleteAllClient();
    void deleteClientById(long id);
    long countClient();
    boolean verifClientById(long id);
    Client selectClientByIdWithOrElse(long id) ;
    Client selectClientByIdWithGet(long id) ;
}
