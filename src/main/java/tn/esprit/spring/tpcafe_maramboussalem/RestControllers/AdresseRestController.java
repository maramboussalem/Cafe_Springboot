package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Adresse.IAdresseServices;
import java.util.List;

@RestController
@RequestMapping("adresse")
@Tag(name = "Adresse", description = "Gestion des Adresses")
@AllArgsConstructor
public class AdresseRestController {

    private IAdresseServices adresseServices;

    @GetMapping
    public List<Adresse> selectAllAdresses() {
         return adresseServices.selectAllAdresses();
    }
    @PostMapping
    public Adresse addAdresse(@RequestBody Adresse adresse) {
        return adresseServices.addAdresse(adresse);
    }
    @PostMapping("addadresse")
    public List<Adresse> addAdresse(@RequestBody List<Adresse> adresses) {
        return adresseServices.saveAdresses(adresses);
    }
    @GetMapping("selectById/{id}")
    public Adresse selectAdresseById(@PathVariable long id) {
        return adresseServices.selectAdresseByIdWithGet(id);
    }
    //http://localhost:8088/adresse/selectById2?id=1
    @GetMapping("selectById2")
    public Adresse selectAdresseById2(@RequestParam long id) {
        return adresseServices.selectAdresseByIdWithOrElse(id);
    }

    @DeleteMapping("deletebyid/{id}")
    public void deleteAdresseById(@PathVariable long id) {
        adresseServices.deleteAdresseById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllAdresses() {
        adresseServices.deleteAllAdresses();
    }

    @GetMapping("count")
    public long countAdresses() {
        return adresseServices.countAdresses();
    }

    @GetMapping("exists/{id}")
    public boolean verifAdresseById(@PathVariable long id) {
        return adresseServices.verifAdresseById(id);
    }
}
