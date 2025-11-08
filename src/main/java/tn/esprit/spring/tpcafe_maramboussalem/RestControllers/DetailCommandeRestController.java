package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.DetailCommande.DetailCommandeResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.DetailCommande.IDetailCommandeService;

import java.util.List;

@RestController
@RequestMapping("detailcommande")
@Tag(name = "DetailCommande", description = "Gestion du Détail de Commande")
@AllArgsConstructor
public class DetailCommandeRestController {

    private IDetailCommandeService detailCommandeService;

    @PostMapping
    public DetailCommandeResponse addDetailCommande(@RequestBody DetailCommandeRequest detailCommandeRequest) {
        return detailCommandeService.addDetailCommande(detailCommandeRequest);
    }


    @GetMapping("/{id}")
    public DetailCommandeResponse getDetailCommande(@PathVariable long id) {
        return detailCommandeService.selectDetailCommandeById(id);
    }


    @GetMapping
    public List<DetailCommandeResponse> getAllDetailCommande() {
        return detailCommandeService.selectAllDetailCommande();
    }


    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable long id) {
        return detailCommandeService.verifDetailCommandeById(id);
    }


    @GetMapping("/count")
    public long count() {
        return detailCommandeService.countDetailCommande();
    }


    @PutMapping("/{id}")
    public DetailCommandeResponse updateDetailCommande(@PathVariable long id, @RequestBody DetailCommandeRequest detailCommandeRequest) {
        return detailCommandeService.updateDetailCommande(id, detailCommandeRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteDetailCommande(@PathVariable long id) {
        detailCommandeService.deleteDetailCommandeById(id);
    }


    @DeleteMapping("/all")
    public void deleteAll() {
        detailCommandeService.deleteAllDetailCommande();
    }
}
