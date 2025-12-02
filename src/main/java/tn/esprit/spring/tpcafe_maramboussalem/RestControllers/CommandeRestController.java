package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Commande.CommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Commande.ICommandeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("commande")
@Tag(name = "Commande", description = "Gestion des Commandes")
public class CommandeRestController {

    private ICommandeService commandeService;

    @PostMapping("/addCommande")
    public CommandeResponse addCommande(@RequestBody CommandeRequest commandeRequest) {
        return commandeService.addCommande(commandeRequest);
    }

    @GetMapping("/getCommandeById/{id}")
    public CommandeResponse getCommande(@PathVariable long id) {
        return commandeService.selectCommandeById(id);
    }

    @GetMapping("/getAllCommandes")
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

    @PutMapping("/updateCommande/{id}")
    public CommandeResponse updateCommande(@PathVariable long id, @RequestBody CommandeRequest commandeRequest) {
        return commandeService.updateCommande(id, commandeRequest);
    }

    @DeleteMapping("/deleteCommande/{id}")
    public void deleteCommande(@PathVariable long id) {
        commandeService.deleteCommandeById(id);
    }

    @DeleteMapping("/deleteAllCommande")
    public void deleteAll() {
        commandeService.deleteAllCommande();
    }


    @GetMapping("/getByStatus/{status}")
    public List<CommandeResponse> getByStatus(@PathVariable String status) {
        return commandeService.findByStatus(status);
    }

    @GetMapping("/getByDate/{date}")
    public List<CommandeResponse> getByDate(@PathVariable LocalDate date) {
        return commandeService.findByDate(date);
    }

    @GetMapping("/countByStatus/{status}")
    public long countByStatus(@PathVariable String status) {
        return commandeService.countByStatus(status);
    }

    @DeleteMapping("/deleteBefore/{date}")
    public void deleteBefore(@PathVariable LocalDate date) {
        commandeService.deleteBefore(date);
    }

    @GetMapping("/betweenDatesAndStatus")
    public List<CommandeResponse> betweenDatesAndStatus(@RequestParam LocalDate d1, @RequestParam LocalDate d2, @RequestParam String status) {
        return commandeService.findBetweenDatesAndStatus(d1, d2, status);
    }

    @GetMapping("/totalGreaterAndStatusNot")
    public List<CommandeResponse> totalGreaterAndStatusNot(@RequestParam float montant, @RequestParam String status) {
        return commandeService.findTotalGreaterAndStatusNot(montant, status);
    }

    @GetMapping("/getByStatuses")
    public List<CommandeResponse> getByStatuses(@RequestParam List<String> statuses) {
        return commandeService.findByStatuses(statuses);
    }

    @GetMapping("/beforeAndTotalBetween")
    public List<CommandeResponse> beforeAndTotalBetween(@RequestParam LocalDate date, @RequestParam float min, @RequestParam float max) {
        return commandeService.findBeforeDateTotalBetween(date, min, max);
    }

    @GetMapping("/endsWithStatus/{suffix}")
    public List<CommandeResponse> endsWithStatus(@PathVariable String suffix) {
        return commandeService.findStatusEndsWith(suffix);
    }

    @GetMapping("/statusNull")
    public List<CommandeResponse> statusNull() {
        return commandeService.findStatusNull();
    }

    @GetMapping("/totalNotNull")
    public List<CommandeResponse> totalNotNull() {
        return commandeService.findTotalNotNull();
    }

    @GetMapping("/withDetailsAndClient")
    public List<CommandeResponse> withDetailsAndClient() {
        return commandeService.findWithDetailsAndClient();
    }

    @GetMapping("/top3Recent")
    public List<CommandeResponse> top3Recent() {
        return commandeService.top3Recent();
    }

    @PostMapping("/affecterCommandeAClient/{idCommande}/{idClient}")
    public void affecterCommandeAClient(@PathVariable long idCommande, @PathVariable long idClient) {
        commandeService.affecterCommandeAClient(idCommande, idClient);
    }

    @PostMapping("/desaffecterClientDeCommande/{idCommande}/{idClient}")
    public void desaffecterClientDeCommande(@PathVariable long idCommande, @PathVariable long idClient) {
        commandeService.desaffecterClientDeCommande(idCommande , idClient);
    }
}
