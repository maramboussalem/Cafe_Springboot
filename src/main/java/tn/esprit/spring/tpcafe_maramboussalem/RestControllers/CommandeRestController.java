package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;
import tn.esprit.spring.tpcafe_maramboussalem.services.Commande.ICommandeService;

import java.util.List;

@RestController
@RequestMapping("commande")
@Tag(name = "Commande", description = "Gestion des Commandes")
@AllArgsConstructor
public class CommandeRestController {

    private ICommandeService commandeService;

    @GetMapping
    public List<Commande> selectAllCommande() {
        return commandeService.selectAllCommande();
    }
    @PostMapping
    public Commande addCommande(@RequestBody Commande commande) {
        return commandeService.addCommande(commande);
    }
    @PostMapping("addCommande")
    public List<Commande> addCommande(@RequestBody List<Commande> commandes) {
        return commandeService.saveCommande(commandes);
    }
    @GetMapping("selectById/{id}")
    public Commande selectCommandeById(@PathVariable long id) {
        return commandeService.selectCommandeByIdWithGet(id);
    }
    @GetMapping("selectById2")
    public Commande selectCommandeById2(@RequestParam long id) {
        return commandeService.selectCommandeByIdWithOrElse(id);
    }
    @DeleteMapping("deletebyid/{id}")
    public void deleteCommandeById(@PathVariable long id) {
        commandeService.deleteCommandeById(id);
    }
    @DeleteMapping("deleteAll")
    public void deleteAllCommande() {
        commandeService.deleteAllCommande();
    }
    @GetMapping("count")
    public long countCommande() {
        return commandeService.countCommande();
    }
    @GetMapping("exists/{id}")
    public boolean verifCommandeById(@PathVariable long id) {
        return commandeService.verifCommandeById(id);
    }
}
