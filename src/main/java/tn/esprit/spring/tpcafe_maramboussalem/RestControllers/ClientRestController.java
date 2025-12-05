package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.*;
import tn.esprit.spring.tpcafe_maramboussalem.services.Client.IClientService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("client")
@Tag(name = "Client", description = "Gestion des Clients")
public class ClientRestController {

    private IClientService clientService;

    @PostMapping("/AddClients")
    public ClientResponse addClient(@RequestBody ClientRequest clientRequest) {
        return clientService.addClient(clientRequest);
    }

    @PostMapping("/saveClients")
    public List<ClientResponse> saveClients(@RequestBody List<ClientRequest> requests) {
        return clientService.saveClients(requests);
    }

    @GetMapping("getClientById/{id}")
    public ClientResponse getClient(@PathVariable long id) {
        return clientService.selectClientById(id);
    }

    @GetMapping("/getAllClients")
    public List<ClientResponse> getAllClients() {
        return clientService.selectAllClient();
    }

    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable long id) {
        return clientService.verifClientById(id);
    }

    @GetMapping("/count")
    public long count() {
        return clientService.countClient();
    }

    @PutMapping("/updateClient/{id}")
    public ClientResponse updateClient(@PathVariable long id, @RequestBody ClientRequest clientRequest) {
        return clientService.updateClient(id, clientRequest);
    }

    @DeleteMapping("/deleteClientById/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @DeleteMapping("/deleteAllClients")
    public void deleteAll() {
        clientService.deleteAllClient();
    }

    @GetMapping("/getByNom/{nom}")
    public List<ClientResponse> getByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @GetMapping("/getByPrenom/{prenom}")
    public List<ClientResponse> getByPrenom(@PathVariable String prenom) {
        return clientService.findByPrenom(prenom);
    }

    @GetMapping("/getByNomAndPrenom")
    public ClientResponse getByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) {
        return clientService.findByNomAndPrenom(nom, prenom);
    }

    @GetMapping("/existsByNom/{nom}")
    public boolean existsByNom(@PathVariable String nom) {
        return clientService.existsByNom(nom);
    }

    @GetMapping("/countBornAfter")
    public long countBornAfter(@RequestParam String date) {
        return clientService.countBornAfter(LocalDate.parse(date));
    }

    @GetMapping("/findNomOrPrenomContains")
    public List<ClientResponse> findNomOrPrenomContains(@RequestParam String str) {
        return clientService.findNomOrPrenomContains(str);
    }

    @GetMapping("/findNomAndPrenomContains")
    public List<ClientResponse> findNomAndPrenomContains(@RequestParam String str) {
        return clientService.findNomAndPrenomContains(str);
    }

    @GetMapping("/bornBetween")
    public List<ClientResponse> bornBetween(@RequestParam String start, @RequestParam String end) {
        return clientService.bornBetween(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/findNomStartsBeforeDate")
    public List<ClientResponse> findNomStartsBeforeDate(@RequestParam String prefix, @RequestParam String date) {
        return clientService.findNomStartsBeforeDate(prefix, LocalDate.parse(date));
    }

    @GetMapping("/findByVille")
    public List<ClientResponse> findByVille(@RequestParam String ville) {
        return clientService.findByVille(ville);
    }

    @GetMapping("/findNomContainsOrderAsc")
    public List<ClientResponse> findNomContainsOrderAsc(@RequestParam String str) {
        return clientService.findNomContainsOrderAsc(str);
    }

    @GetMapping("/findNomContainsOrderDesc")
    public List<ClientResponse> findNomContainsOrderDesc(@RequestParam String str) {
        return clientService.findNomContainsOrderDesc(str);
    }

    @GetMapping("/findNomStartsWith")
    public List<ClientResponse> findNomStartsWith(@RequestParam String prefix) {
        return clientService.findNomStartsWith(prefix);
    }

    @GetMapping("/findPrenomEndsWith")
    public List<ClientResponse> findPrenomEndsWith(@RequestParam String suffix) {
        return clientService.findPrenomEndsWith(suffix);
    }

    @GetMapping("/findNoDateNaissance")
    public List<ClientResponse> findNoDateNaissance() {
        return clientService.findNoDateNaissance();
    }

    @GetMapping("/findAdresseNotNull")
    public List<ClientResponse> findAdresseNotNull() {
        return clientService.findAdresseNotNull();
    }

    @GetMapping("/findByVilles")
    public List<ClientResponse> findByVilles(@RequestParam List<String> villes) {
        return clientService.findByVilles(villes);
    }

    @GetMapping("/findByPointsGreater")
    public List<ClientResponse> findByPointsGreater(@RequestParam int pts) {
        return clientService.findByPointsGreater(pts);
    }

    @GetMapping("/findByPointsGreaterOrEqual")
    public List<ClientResponse> findByPointsGreaterOrEqual(@RequestParam int pts) {
        return clientService.findByPointsGreaterOrEqual(pts);
    }

    @GetMapping("/findPointsBetween")
    public List<ClientResponse> findPointsBetween(@RequestParam int min, @RequestParam int max) {
        return clientService.findPointsBetween(min, max);
    }

    @GetMapping("/orderedArticle")
    public List<ClientResponse> orderedArticle(@RequestParam String article) {
        return clientService.orderedArticle(article);
    }

    @GetMapping("/search/nameContainsOrderedType")
    public List<ClientResponse> nameContainsAndOrderedType(@RequestParam String str, @RequestParam TypeArticle type) {
        return clientService.nameContainsAndOrderedType(str, type);
    }

    @PostMapping("/addClientWithCarte")
    public Client addClientWithCarte(@RequestBody Client client) {
        return clientService.ajouterClientEtCarteFidelite(client);
    }

    @PostMapping("/ajouterClientEtCarteFidelite")
    public String ajouterClientEtCarteFidelite(@RequestBody CarteFidelite carteFid) {
        clientService.ajouterClientEtCarteFidelite(carteFid);
        return "Carte ajoutée avec succès !";
    }

    @PostMapping("/ajouterCommandeEtAffectationAClient")
    public void ajouterCommandeV2(@RequestBody Commande commande, @RequestParam String nomClient, @RequestParam String prenomClient) {
        clientService.ajouterCommandeEtAffectationAClient(commande, nomClient, prenomClient);
    }


    @PostMapping("/ajouterEtAffecterAdresseAClient")
    public void ajouterAdresse(@RequestBody Adresse adresse, @RequestBody Client client) {
        clientService.ajouterEtAffecterAdresseAClient(adresse, client);
    }

}
