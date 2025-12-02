package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Adresse.IAdresseServices;
import java.util.List;

@RestController
@RequestMapping("adresse")
@Tag(name = "Adresse", description = "Gestion des Adresses")
@AllArgsConstructor
public class AdresseRestController {

    private IAdresseServices adresseService;

    @PostMapping
    public AdresseResponse addAdresse(@RequestBody AdresseRequest adresseRequest) {
        return adresseService.addAdresse(adresseRequest);
    }

    @GetMapping("/{id}")
    public AdresseResponse getAdresse(@PathVariable long id) {
        return adresseService.selectAdresseById(id);
    }

    @GetMapping
    public List<AdresseResponse> getAllAdresses() {
        return adresseService.selectAllAdresses();
    }

    @GetMapping("/exists/{id}")
    public boolean verifAdresseById(@PathVariable long id) {
        return adresseService.verifAdresseById(id);
    }

    @GetMapping("/count")
    public long countAdresse() {
        return adresseService.countAdresses();
    }

    @PutMapping("/{id}")
    public AdresseResponse updateAdresse(@PathVariable long id, @RequestBody AdresseRequest adresseRequest) {
        return adresseService.updateAdresse(id, adresseRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAdresse(@PathVariable long id) {
        adresseService.deleteAdresseById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllAdresses() {
        adresseService.deleteAllAdresses();
    }
}
