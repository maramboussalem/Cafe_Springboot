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

    @PostMapping ("/addDetailCommande")
    public DetailCommandeResponse addDetailCommande(@RequestBody DetailCommandeRequest detailCommandeRequest) {
        return detailCommandeService.addDetailCommande(detailCommandeRequest);
    }

    @GetMapping("/getDetailCommandeById/{id}")
    public DetailCommandeResponse getDetailCommande(@PathVariable long id) {
        return detailCommandeService.selectDetailCommandeById(id);
    }

    @GetMapping("/getAllDetailCommande")
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

    @GetMapping("/getByQuantity/{qty}")
    public List<DetailCommandeResponse> getByQuantity(@PathVariable int qty) {
        return detailCommandeService.findByQuantiteExact(qty);
    }

    @GetMapping("/getBySousTotal/{st}")
    public List<DetailCommandeResponse> getBySousTotal(@PathVariable float st) {
        return detailCommandeService.findBySousTotalExact(st);
    }

    @GetMapping("/countQtyGreater/{qty}")
    public long countQtyGreater(@PathVariable int qty) {
        return detailCommandeService.countQuantityGreater(qty);
    }

    @GetMapping("/existsSousTotal/{st}")
    public boolean existsSousTotal(@PathVariable float st) {
        return detailCommandeService.existsBySousTotalGreater(st);
    }

    @GetMapping("/getQtyRange")
    public List<DetailCommandeResponse> getQtyRange(@RequestParam int min, @RequestParam int max, @RequestParam float stMin) {
        return detailCommandeService.findByQuantiteRangeAndSousTotal(min, max, stMin);
    }

    @GetMapping("/getSousTotalRange")
    public List<DetailCommandeResponse> getSousTotalRange(@RequestParam float min, @RequestParam float max) {
        return detailCommandeService.findBySousTotalRangeOrderByQty(min, max);
    }

    @GetMapping("/getSousTotalPromoRangee")
    public List<DetailCommandeResponse> getSousTotalPromoRange(@RequestParam float min, @RequestParam float max) {
        return detailCommandeService.findBySousTotalPromoRange(min, max);
    }

    @GetMapping("/qtyOrSousTotal")
    public List<DetailCommandeResponse> qtyOrSousTotal(@RequestParam int qty, @RequestParam float st) {
        return detailCommandeService.findByQtyOrSousTotalMin(qty, st);
    }

    @GetMapping("/top5")
    public List<DetailCommandeResponse> top5() {
        return detailCommandeService.top5Expensive();
    }

    @GetMapping("/getQtyNull")
    public List<DetailCommandeResponse> getQtyNull() {
        return detailCommandeService.findQuantityNull();
    }

    @GetMapping("/getSousTotalPromoNotNull")
    public List<DetailCommandeResponse> getSousTotalPromoNotNull() {
        return detailCommandeService.findSousTotalPromoNotNull();
    }

    @GetMapping("/getWithCommandeAndArticle")
    public List<DetailCommandeResponse> getWithCommandeAndArticle() {
        return detailCommandeService.findWithCommandeAndArticle();
    }

}
