package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.TypeArticle;
import tn.esprit.spring.tpcafe_maramboussalem.services.Client.IClientService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("client")
@Tag(name = "Client", description = "Gestion des Clients")
@AllArgsConstructor
public class ClientRestController {

    private IClientService clientService;

    @PostMapping
    public ClientResponse addClient(@RequestBody ClientRequest clientRequest) {
        return clientService.addClient(clientRequest);
    }

    @PostMapping("/clients")
    public List<ClientResponse> saveClients(@RequestBody List<ClientRequest> requests) {
        return clientService.saveClients(requests);
    }

    @GetMapping("/{id}")
    public ClientResponse getClient(@PathVariable long id) {
        return clientService.selectClientById(id);
    }

    @GetMapping
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

    @PutMapping("/{id}")
    public ClientResponse updateClient(@PathVariable long id, @RequestBody ClientRequest clientRequest) {
        return clientService.updateClient(id, clientRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        clientService.deleteAllClient();
    }

    @GetMapping("/search/byNom/{nom}")
    public List<ClientResponse> getByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }

    @GetMapping("/search/byPrenom/{prenom}")
    public List<ClientResponse> getByPrenom(@PathVariable String prenom) {
        return clientService.findByPrenom(prenom);
    }

    @GetMapping("/search/byNomAndPrenom")
    public ClientResponse getByNomAndPrenom(@RequestParam String nom, @RequestParam String prenom) {
        return clientService.findByNomAndPrenom(nom, prenom);
    }

    @GetMapping("/search/existsByNom/{nom}")
    public boolean existsByNom(@PathVariable String nom) {
        return clientService.existsByNom(nom);
    }

    @GetMapping("/search/countBornAfter")
    public long countBornAfter(@RequestParam String date) {
        return clientService.countBornAfter(LocalDate.parse(date));
    }

    @GetMapping("/search/nameContains")
    public List<ClientResponse> findNomOrPrenomContains(@RequestParam String str) {
        return clientService.findNomOrPrenomContains(str);
    }

    @GetMapping("/search/nameAndSurnameContains")
    public List<ClientResponse> findNomAndPrenomContains(@RequestParam String str) {
        return clientService.findNomAndPrenomContains(str);
    }

    @GetMapping("/search/bornBetween")
    public List<ClientResponse> bornBetween(@RequestParam String start, @RequestParam String end) {
        return clientService.bornBetween(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/search/nameStartsBeforeDate")
    public List<ClientResponse> findNomStartsBeforeDate(@RequestParam String prefix,
                                                        @RequestParam String date) {
        return clientService.findNomStartsBeforeDate(prefix, LocalDate.parse(date));
    }

    @GetMapping("/search/byVille")
    public List<ClientResponse> findByVille(@RequestParam String ville) {
        return clientService.findByVille(ville);
    }

    @GetMapping("/search/nameContainsOrderAsc")
    public List<ClientResponse> findNomContainsOrderAsc(@RequestParam String str) {
        return clientService.findNomContainsOrderAsc(str);
    }

    @GetMapping("/search/nameContainsOrderDesc")
    public List<ClientResponse> findNomContainsOrderDesc(@RequestParam String str) {
        return clientService.findNomContainsOrderDesc(str);
    }

    @GetMapping("/search/nameStartsWith")
    public List<ClientResponse> findNomStartsWith(@RequestParam String prefix) {
        return clientService.findNomStartsWith(prefix);
    }

    @GetMapping("/search/surnameEndsWith")
    public List<ClientResponse> findPrenomEndsWith(@RequestParam String suffix) {
        return clientService.findPrenomEndsWith(suffix);
    }

    @GetMapping("/search/noDateNaissance")
    public List<ClientResponse> findNoDateNaissance() {
        return clientService.findNoDateNaissance();
    }

    @GetMapping("/search/hasAdresse")
    public List<ClientResponse> findAdresseNotNull() {
        return clientService.findAdresseNotNull();
    }

    @GetMapping("/search/byVilles")
    public List<ClientResponse> findByVilles(@RequestParam List<String> villes) {
        return clientService.findByVilles(villes);
    }

    @GetMapping("/search/pointsGreater")
    public List<ClientResponse> findByPointsGreater(@RequestParam int pts) {
        return clientService.findByPointsGreater(pts);
    }

    @GetMapping("/search/pointsGreaterOrEqual")
    public List<ClientResponse> findByPointsGreaterOrEqual(@RequestParam int pts) {
        return clientService.findByPointsGreaterOrEqual(pts);
    }

    @GetMapping("/search/pointsBetween")
    public List<ClientResponse> findPointsBetween(@RequestParam int min, @RequestParam int max) {
        return clientService.findPointsBetween(min, max);
    }

    @GetMapping("/search/orderedArticle")
    public List<ClientResponse> orderedArticle(@RequestParam String article) {
        return clientService.orderedArticle(article);
    }

    @GetMapping("/search/nameContainsOrderedType")
    public List<ClientResponse> nameContainsAndOrderedType(@RequestParam String str,
                                                           @RequestParam TypeArticle type) {
        return clientService.nameContainsAndOrderedType(str, type);
    }




}
