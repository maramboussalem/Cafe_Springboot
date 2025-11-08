package tn.esprit.spring.tpcafe_maramboussalem.services.Client;


import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;

import java.util.List;

public interface IClientService {
    ClientResponse addClient(ClientRequest clientRequest);
    ClientResponse updateClient(long id ,ClientRequest clientRequest);

    ClientResponse selectClientById(long id);
    List<ClientResponse> selectAllClient();

    void deleteAllClient();
    void deleteClientById(long id);

    long countClient();
    boolean verifClientById(long id);
}
