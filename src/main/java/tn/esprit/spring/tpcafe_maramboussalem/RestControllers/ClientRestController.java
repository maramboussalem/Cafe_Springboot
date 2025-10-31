package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.services.Client.IClientService;
import java.util.List;

@RestController
@RequestMapping("client")
@Tag(name = "Client", description = "Gestion des Clients")
@AllArgsConstructor
public class ClientRestController {

    private IClientService clientService;

    @GetMapping
    public List<Client> selectAllClient() {
        return clientService.selectAllClient();
    }
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }
    @PostMapping("addclient")
    public List<Client> addclient(@RequestBody List<Client> clients) {
        return clientService.saveClient(clients);
    }
    @GetMapping("selectById/{id}")
    public Client selectClientById(@PathVariable long id) {
        return clientService.selectClientByIdWithGet(id);
    }
    @GetMapping("selectById2")
    public Client selectClientById2(@RequestParam long id) {
        return clientService.selectClientByIdWithOrElse(id);
    }
    @DeleteMapping("deletebyid/{id}")
    public void deleteClientById(@PathVariable long id) {
        clientService.deleteClientById(id);
    }
    @DeleteMapping("deleteAll")
    public void deleteAllClients() {
        clientService.deleteAllClient();
    }
    @GetMapping("count")
    public long countClient() {
        return clientService.countClient();
    }
    @GetMapping("exists/{id}")
    public boolean verifClientById(@PathVariable long id) {
        return clientService.verifClientById(id);
    }
}
