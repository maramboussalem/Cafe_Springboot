package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Commande.ICommandeService;

import java.util.List;

@RestController
@RequestMapping("commande")
@Tag(name = "Commande", description = "Gestion des Commandes")
@AllArgsConstructor
public class CommandeRestController {

    private ICommandeService commandeService;

    @PostMapping
    public CommandeResponse addCommande(@RequestBody CommandeRequest commandeRequest) {
        return commandeService.addCommande(commandeRequest);
    }

    @GetMapping("/{id}")
    public CommandeResponse getCommande(@PathVariable long id) {
        return commandeService.selectCommandeById(id);
    }

    @GetMapping
    public List<CommandeResponse> getAllCommandes() {
        return commandeService.selectAllCommande();
    }

    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable long id) {
        return commandeService.verifCommandeById(id);
    }

    @GetMapping("/count")
    public long count() {
        return commandeService.countCommande();
    }

    @PutMapping("/{id}")
    public CommandeResponse updateCommande(@PathVariable long id, @RequestBody CommandeRequest commandeRequest) {
        return commandeService.updateCommande(id, commandeRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable long id) {
        commandeService.deleteCommandeById(id);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        commandeService.deleteAllCommande();
    }
}
