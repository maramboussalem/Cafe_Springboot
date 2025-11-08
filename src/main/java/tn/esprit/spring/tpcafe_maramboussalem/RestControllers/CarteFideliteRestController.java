package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite.ICarteFideliteService;

import java.util.List;

@RestController
@RequestMapping("cartefidelite")
@Tag(name = "CarteFidelite", description = "Gestion des Cartes de Fidélité")
@AllArgsConstructor
public class CarteFideliteRestController {

    private final ICarteFideliteService carteFideliteService;

    @PostMapping
    public CarteFideliteResponse addCarte(@RequestBody CarteFideliteRequest carteFideliteRequest) {
        return carteFideliteService.addCarte(carteFideliteRequest);
    }

    @GetMapping("/{id}")
    public CarteFideliteResponse getCarte(@PathVariable long id) {
        return carteFideliteService.getCarteById(id);
    }

    @GetMapping
    public List<CarteFideliteResponse> getAllCartes() {
        return carteFideliteService.getAllCartes();
    }

    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable long id) {
        return carteFideliteService.verifCarteById(id);
    }

    @GetMapping("/count")
    public long count() {
        return carteFideliteService.countCartes();
    }

    @PutMapping("/{id}")
    public CarteFideliteResponse updateCarte(@PathVariable long id, @RequestBody CarteFideliteRequest request) {
        return carteFideliteService.updateCarte(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCarte(@PathVariable long id) {
        carteFideliteService.deleteCarteById(id);
    }

    @DeleteMapping("/all")
    public void deleteAll() {
        carteFideliteService.deleteAllCartes();
    }
}
