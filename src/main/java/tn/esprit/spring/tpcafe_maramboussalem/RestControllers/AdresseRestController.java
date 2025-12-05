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

    @GetMapping
    public List<AdresseResponse> getAllAdresses() {
        return adresseService.selectAllAdresses();
    }

    @GetMapping("/{id}")
    public AdresseResponse getAdresse(@PathVariable long id) {
        return adresseService.selectAdresseById(id);
    }

    @PostMapping
    public AdresseResponse addAdresse(@RequestBody AdresseRequest adresseRequest) {
        return adresseService.addAdresse(adresseRequest);
    }

    @PostMapping("/adresses")
    public List<AdresseResponse> saveAdresses(@RequestBody List<AdresseRequest> adresseRequests) {
        return adresseService.saveAdresses(adresseRequests);
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

    @GetMapping("/ville/{ville}")
    public List<AdresseResponse> findByVille(@PathVariable String ville) {
        return adresseService.findByVille(ville);
    }

    @GetMapping("/codePostal/{cp}")
    public List<AdresseResponse> findByCodePostal(@PathVariable Integer cp) {
        return adresseService.findByCodePostal(cp);
    }

    @GetMapping("/ville/{ville}/count")
    public long countByVille(@PathVariable String ville) {
        return adresseService.countByVille(ville);
    }

    @DeleteMapping("/ville/{ville}")
    public void deleteByVille(@PathVariable String ville) {
        adresseService.deleteByVille(ville);
    }

    @GetMapping("/ville-cp")
    public List<AdresseResponse> findByVilleAndCp(@RequestParam String ville, @RequestParam Integer cp) {
        return adresseService.findByVilleAndCodePostal(ville, cp);
    }

    @GetMapping("/rue-ville")
    public List<AdresseResponse> searchRueVille(
            @RequestParam String mot,
            @RequestParam String ville) {
        return adresseService.findByRueContainingIgnoreCaseAndVille(mot, ville);
    }

    @PostMapping("/villes")
    public List<AdresseResponse> findByVilleIn(@RequestBody List<String> villes) {
        return adresseService.findByVilleIn(villes);
    }

    @GetMapping("/cp-between")
    public List<AdresseResponse> findBetweenCp(@RequestParam Integer min, @RequestParam Integer max) {
        return adresseService.findByCodePostalBetween(min, max);
    }

    @GetMapping("/cp-greater/{cp}")
    public List<AdresseResponse> greaterThan(@PathVariable Integer cp) {
        return adresseService.findByCodePostalGreaterThan(cp);
    }

    @GetMapping("/cp-greater-eq/{cp}")
    public List<AdresseResponse> greaterThanEqual(@PathVariable Integer cp) {
        return adresseService.findByCodePostalGreaterThanEqual(cp);
    }

    @GetMapping("/cp-less/{cp}")
    public List<AdresseResponse> less(@PathVariable Integer cp) {
        return adresseService.findByCodePostalLessThan(cp);
    }

    @GetMapping("/cp-less-eq/{cp}")
    public List<AdresseResponse> lessEq(@PathVariable Integer cp) {
        return adresseService.findByCodePostalLessThanEqual(cp);
    }

    @GetMapping("/rue-starts")
    public List<AdresseResponse> rueStarts(
            @RequestParam String prefix,
            @RequestParam String ville) {
        return adresseService.findByRueStartsWithAndVille(prefix, ville);
    }

    @GetMapping("/rue-starts/{prefix}")
    public List<AdresseResponse> rueStartsOnly(@PathVariable String prefix) {
        return adresseService.findByRueStartsWith(prefix);
    }

    @GetMapping("/ville-ends/{suffix}")
    public List<AdresseResponse> villeEnds(@PathVariable String suffix) {
        return adresseService.findByVilleEndsWith(suffix);
    }

    @GetMapping("/rue-null")
    public List<AdresseResponse> findRueNull() {
        return adresseService.findByRueIsNull();
    }

    @GetMapping("/ville-not-null")
    public List<AdresseResponse> findVilleNotNull() {
        return adresseService.findByVilleIsNotNull();
    }

}
