package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite.ICarteFideliteService;

import java.util.List;

@RestController
@RequestMapping("cartefidelite")
@Tag(name = "CarteFidelite", description = "Gestion des Cartes de Fidelite")
@AllArgsConstructor
public class CarteFideliteRestController {

    private ICarteFideliteService carteFideliteService;

    @GetMapping
    public List<CarteFidelite> selectAllCarteFidelite() {
        return carteFideliteService.selectAllCarteFidelite();
    }
    @PostMapping
    public CarteFidelite addCarteFidelite(@RequestBody CarteFidelite carteFidelite) {
        return carteFideliteService.addCarteFidelite(carteFidelite);
    }
    @PostMapping("addcartefidelite")
    public List<CarteFidelite> addCarteFidelite(@RequestBody List<CarteFidelite> carteFidelites) {
        return carteFideliteService.saveCarteFidelite(carteFidelites);
    }
    @GetMapping("selectById/{id}")
    public CarteFidelite selectCarteFideliteById(@PathVariable long id) {
        return carteFideliteService.selectCarteFideliteByIdWithGet(id);
    }
    @GetMapping("selectById2")
    public CarteFidelite selectCarteFideliteById2(@RequestParam long id) {
        return carteFideliteService.selectCarteFideliteByIdWithOrElse(id);
    }
    @DeleteMapping("deletebyid/{id}")
    public void deleteCarteFideliteById(@PathVariable long id) {
        carteFideliteService.deleteCarteFideliteById(id);
    }
    @DeleteMapping("deleteAll")
    public void deleteAllCarteFidelite() {
        carteFideliteService.deleteAllCarteFidelite();
    }
    @GetMapping("count")
    public long countCarteFidelite() {
        return carteFideliteService.countCarteFidelite();
    }
    @GetMapping("exists/{id}")
    public boolean verifCarteFideliteById(@PathVariable long id) {
        return carteFideliteService.verifCarteFideliteById(id);
    }

}
