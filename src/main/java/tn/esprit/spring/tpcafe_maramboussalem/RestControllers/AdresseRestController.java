package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.AdresseRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ClientRepository;
import tn.esprit.spring.tpcafe_maramboussalem.services.Adresse.IAdresseServices;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("adresse")
@Tag(name = "Adresse", description = "Gestion des Adresses")
public class AdresseRestController {

    private AdresseRepository adresseRepository;
    private ClientRepository clientRepository;
    private IAdresseServices adresseService;

    @GetMapping("/getAllAdresses")
    public List<AdresseResponse> getAllAdresses() {
        return adresseService.selectAllAdresses();
    }

    @GetMapping("/getAdresse/{id}")
    public AdresseResponse getAdresse(@PathVariable long id) {
        return adresseService.selectAdresseById(id);
    }

    @PostMapping("/addAdresse")
    public AdresseResponse addAdresse(@RequestBody AdresseRequest adresseRequest) {
        return adresseService.addAdresse(adresseRequest);
    }

    @PostMapping("/saveAdresses")
    public List<AdresseResponse> saveAdresses(@RequestBody List<AdresseRequest> adresseRequests) {
        return adresseService.saveAdresses(adresseRequests);
    }

    @GetMapping("/verifAdresseById/{id}")
    public boolean verifAdresseById(@PathVariable long id) {
        return adresseService.verifAdresseById(id);
    }

    @GetMapping("/countAdresse")
    public long countAdresse() {
        return adresseService.countAdresses();
    }

    @PutMapping("/updateAdresse/{id}")
    public AdresseResponse updateAdresse(@PathVariable long id, @RequestBody AdresseRequest adresseRequest) {
        return adresseService.updateAdresse(id, adresseRequest);
    }

    @DeleteMapping("/deleteAdresse/{id}")
    public void deleteAdresse(@PathVariable long id) {
        adresseService.deleteAdresseById(id);
    }

    @DeleteMapping("/deleteAllAdresses")
    public void deleteAllAdresses() {
        adresseService.deleteAllAdresses();
    }

    @GetMapping("/findByVille/{ville}")
    public List<AdresseResponse> findByVille(@PathVariable String ville) {
        return adresseService.findByVille(ville);
    }

    @GetMapping("/findByCodePostal/{cp}")
    public List<AdresseResponse> findByCodePostal(@PathVariable Integer cp) {
        return adresseService.findByCodePostal(cp);
    }

    @GetMapping("/countByVille/{ville}/count")
    public long countByVille(@PathVariable String ville) {
        return adresseService.countByVille(ville);
    }

    @DeleteMapping("/deleteByVille/{ville}")
    public void deleteByVille(@PathVariable String ville) {
        adresseService.deleteByVille(ville);
    }

    @GetMapping("/findByVilleAndCp")
    public List<AdresseResponse> findByVilleAndCp(@RequestParam String ville, @RequestParam Integer cp) {
        return adresseService.findByVilleAndCodePostal(ville, cp);
    }

    @GetMapping("/searchRueVille")
    public List<AdresseResponse> searchRueVille(@RequestParam String mot, @RequestParam String ville) {
        return adresseService.findByRueContainingIgnoreCaseAndVille(mot, ville);
    }

    @PostMapping("/findByVilleIn")
    public List<AdresseResponse> findByVilleIn(@RequestBody List<String> villes) {
        return adresseService.findByVilleIn(villes);
    }

    @GetMapping("/findBetweenCp")
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

    @GetMapping("/rueStarts")
    public List<AdresseResponse> rueStarts(
            @RequestParam String prefix,
            @RequestParam String ville) {
        return adresseService.findByRueStartsWithAndVille(prefix, ville);
    }

    @GetMapping("/rueStartsOnly/{prefix}")
    public List<AdresseResponse> rueStartsOnly(@PathVariable String prefix) {
        return adresseService.findByRueStartsWith(prefix);
    }

    @GetMapping("/villeEnds/{suffix}")
    public List<AdresseResponse> villeEnds(@PathVariable String suffix) {
        return adresseService.findByVilleEndsWith(suffix);
    }

    @GetMapping("/findRueNull")
    public List<AdresseResponse> findRueNull() {
        return adresseService.findByRueIsNull();
    }

    @GetMapping("/findVilleNotNull")
    public List<AdresseResponse> findVilleNotNull() {
        return adresseService.findByVilleIsNotNull();
    }

    @PostMapping("/ajouterEtAffecterAdresseAClient/{idAdresse}/{idClient}")
    public void ajouterEtAffecterAdresseAClient(@PathVariable long idAdresse, @PathVariable long idClient) {
        Adresse adresse = adresseRepository.findById(idAdresse).get();
        Client client = clientRepository.findById(idClient).get();
        adresseService.ajouterEtAffecterAdresseAClient(adresse, client);
    }

}
