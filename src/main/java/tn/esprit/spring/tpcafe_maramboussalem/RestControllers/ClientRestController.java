package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Client.ClientResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Client.IClientService;
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
}
