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


    @GetMapping("/status/{status}")
    public List<CommandeResponse> getByStatus(@PathVariable String status) {
        return commandeService.findByStatus(status);
    }
    @GetMapping("/date/{date}")
    public List<CommandeResponse> getByDate(@PathVariable LocalDate date) {
        return commandeService.findByDate(date);
    }
    @GetMapping("/count/status/{status}")
    public long countByStatus(@PathVariable String status) {
        return commandeService.countByStatus(status);
    }
    @DeleteMapping("/before/{date}")
    public void deleteBefore(@PathVariable LocalDate date) {
        commandeService.deleteBefore(date);
    }
    @GetMapping("/between")
    public List<CommandeResponse> betweenDatesAndStatus(
            @RequestParam LocalDate d1,
            @RequestParam LocalDate d2,
            @RequestParam String status) {
        return commandeService.findBetweenDatesAndStatus(d1, d2, status);
    }
    @GetMapping("/totalGreater")
    public List<CommandeResponse> totalGreaterAndStatusNot(
            @RequestParam float montant,
            @RequestParam String status) {
        return commandeService.findTotalGreaterAndStatusNot(montant, status);
    }

    @GetMapping("/statuses")
    public List<CommandeResponse> getByStatuses(@RequestParam List<String> statuses) {
        return commandeService.findByStatuses(statuses);
    }

    @GetMapping("/before")
    public List<CommandeResponse> beforeAndTotalBetween(
            @RequestParam LocalDate date,
            @RequestParam float min,
            @RequestParam float max) {
        return commandeService.findBeforeDateTotalBetween(date, min, max);
    }

    @GetMapping("/status/ends/{suffix}")
    public List<CommandeResponse> endsWithStatus(@PathVariable String suffix) {
        return commandeService.findStatusEndsWith(suffix);
    }

    @GetMapping("/status/null")
    public List<CommandeResponse> statusNull() {
        return commandeService.findStatusNull();
    }

    @GetMapping("/total/notnull")
    public List<CommandeResponse> totalNotNull() {
        return commandeService.findTotalNotNull();
    }

    @GetMapping("/withDetails")
    public List<CommandeResponse> withDetailsAndClient() {
        return commandeService.findWithDetailsAndClient();
    }

    @GetMapping("/top3")
    public List<CommandeResponse> top3Recent() {
        return commandeService.top3Recent();
    }
}
