package tn.esprit.spring.tpcafe_maramboussalem.services.Client;


import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface IClientService {
    ClientResponse addClient(ClientRequest clientRequest);
    List<ClientResponse> saveClients(List<ClientRequest> requests);

    ClientResponse updateClient(long id ,ClientRequest clientRequest);

    ClientResponse selectClientById(long id);
    List<ClientResponse> selectAllClient();

    void deleteAllClient();
    void deleteClientById(long id);

    long countClient();
    boolean verifClientById(long id);

    List<ClientResponse> findByNom(String nom);
    List<ClientResponse> findByPrenom(String prenom);
    ClientResponse findByNomAndPrenom(String nom, String prenom);
    boolean existsByNom(String nom);
    long countBornAfter(LocalDate date);
    List<ClientResponse> findNomOrPrenomContains(String str);
    List<ClientResponse> findNomAndPrenomContains(String str);
    List<ClientResponse> bornBetween(LocalDate d1, LocalDate d2);
    List<ClientResponse> findNomStartsBeforeDate(String prefix, LocalDate date);
    List<ClientResponse> findByVille(String ville);
    List<ClientResponse> findNomContainsOrderAsc(String str);
    List<ClientResponse> findNomContainsOrderDesc(String str);
    List<ClientResponse> findNomStartsWith(String prefix);
    List<ClientResponse> findPrenomEndsWith(String suffix);
    List<ClientResponse> findNoDateNaissance();
    List<ClientResponse> findAdresseNotNull();
    List<ClientResponse> findByVilles(List<String> villes);

    List<ClientResponse> findByPointsGreater(int pts);
    List<ClientResponse> findByPointsGreaterOrEqual(int pts);
    List<ClientResponse> findPointsBetween(int min, int max);

    List<ClientResponse> orderedArticle(String article);
    List<ClientResponse> nameContainsAndOrderedType(String str, TypeArticle type);

    Client ajouterClientEtCarteFidelite(Client client);

    void ajouterCommandeEtAffectationAClient(Commande c, String nomClient, String prenomClient);
    void ajouterClientEtCarteFidelite(CarteFidelite carteFid) ;

    void ajouterEtAffecterAdresseAClient(Adresse a, Client c);
    //List<Client> incrementerPoints();

}
