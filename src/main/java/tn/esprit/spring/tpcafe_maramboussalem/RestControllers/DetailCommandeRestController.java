package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.entities.DetailCommande;
import tn.esprit.spring.tpcafe_maramboussalem.services.DetailCommande.IDetailCommandeService;

import java.util.List;

@RestController
@RequestMapping("detailcommande")
@Tag(name = "DetailCommande", description = "Gestion du Détail de Commande")
@AllArgsConstructor
public class DetailCommandeRestController {

    private IDetailCommandeService detailCommandeService;

    @GetMapping
    public List<DetailCommande> selectAllDetailCommande() {
        return detailCommandeService.selectAllDetailCommande();
    }
    @PostMapping
    public DetailCommande addDetailCommande(@RequestBody DetailCommande detailCommande) {
        return detailCommandeService.addDetailCommande(detailCommande);
    }
    @PostMapping("adddetailcommande")
    public List<DetailCommande> addDetailCommande(@RequestBody List<DetailCommande> detailCommandes) {
        return detailCommandeService.saveDetailCommande(detailCommandes);
    }
    @GetMapping("selectById/{id}")
    public DetailCommande selectDetailCommandeById(@PathVariable long id) {
        return detailCommandeService.selectDetailCommandeByIdWithGet(id);
    }
    @GetMapping("selectById2")
    public DetailCommande selectDetailCommandeById2(@RequestParam long id) {
        return detailCommandeService.selectDetailCommandeByIdWithOrElse(id);
    }
    @DeleteMapping("deletebyid/{id}")
    public void deleteDetailCommandeById(@PathVariable long id) {
        detailCommandeService.deleteDetailCommandeById(id);
    }
    @DeleteMapping("deleteAll")
    public void deleteAllDetailCommandes() {
        detailCommandeService.deleteAllDetailCommande();
    }
    @GetMapping("count")
    public long countDetailCommandes() {
        return detailCommandeService.countDetailCommande();
    }
    @GetMapping("exists/{id}")
    public boolean verifDetailCommandeById(@PathVariable long id) {
        return detailCommandeService.verifDetailCommandeById(id);
    }
}
