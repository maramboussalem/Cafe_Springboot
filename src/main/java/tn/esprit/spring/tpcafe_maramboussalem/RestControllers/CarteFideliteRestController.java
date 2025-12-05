package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite.ICarteFideliteService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("cartefidelite")
@Tag(name = "CarteFidelite", description = "Gestion des Cartes de Fidélité")
public class CarteFideliteRestController {

    private final ICarteFideliteService carteFideliteService;

    @PostMapping("/addCarteFidelite")
    public CarteFideliteResponse addCarte(@RequestBody CarteFideliteRequest carteFideliteRequest) {
        return carteFideliteService.addCarte(carteFideliteRequest);
    }

    @GetMapping("/getCartebyId/{id}")
    public CarteFideliteResponse getCarte(@PathVariable long id) {
        return carteFideliteService.getCarteById(id);
    }

    @GetMapping("/getAllCartes")
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

    @DeleteMapping("/deleteCarte/{id}")
    public void deleteCarte(@PathVariable long id) {
        carteFideliteService.deleteCarteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        carteFideliteService.deleteAllCartes();
    }

    @GetMapping("/findByExactPoints/{points}")
    public List<CarteFideliteResponse> findByExactPoints(@PathVariable int points) {
        return carteFideliteService.findByExactPoints(points);
    }

    @GetMapping("/findByDate/{date}")
    public List<CarteFideliteResponse> findByDate( @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return carteFideliteService.findByDateCreation(date);
    }

    @GetMapping("/countByPointsGreater/{points}")
    public long countByPointsGreater(@PathVariable int points) {
        return carteFideliteService.countByPointsGreater(points);
    }

    @DeleteMapping("/deleteByDateBefore/{date}")
    public void deleteByDateBefore(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        carteFideliteService.deleteByDateBefore(date);
    }

    @GetMapping("/findPointsBetweenAfterDate")
    public List<CarteFideliteResponse> findPointsBetweenAfterDate(@RequestParam int min, @RequestParam int max,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return carteFideliteService.findPointsBetweenAfterDate(min, max, date);
    }

    @GetMapping("/findPointsGreaterSorted/{points}")
    public List<CarteFideliteResponse> findPointsGreaterSorted(@PathVariable int points) {
        return carteFideliteService.findByPointsGreaterSortedByDate(points);
    }

    @GetMapping("/findDateBetween")
    public List<CarteFideliteResponse> findDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return carteFideliteService.findByDateBetween(start, end);
    }

    @GetMapping("/findPointsLessOrDateBefore")
    public List<CarteFideliteResponse> findPointsLessOrDateBefore(
            @RequestParam int points,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return carteFideliteService.findPointsLessOrDateBefore(points, date);
    }

    @GetMapping("/findCarteWithMaxPoints")
    public List<CarteFideliteResponse> findCarteWithMaxPoints() {
        return carteFideliteService.findCarteWithMaxPoints();
    }

    @GetMapping("/findCarteNoDate")
    public List<CarteFideliteResponse> findCarteNoDate() {
        return carteFideliteService.findCarteNoDate();
    }

    @GetMapping("/findCartePointsNotNull")
    public List<CarteFideliteResponse> findCartePointsNotNull() {
        return carteFideliteService.findCartePointsNotNull();
    }

    @GetMapping("/findByClientNomPrenom")
    public List<CarteFideliteResponse> findByClientNomPrenom(@RequestParam String nom, @RequestParam String prenom) {
        return carteFideliteService.findByClientNomPrenom(nom, prenom);
    }

    @GetMapping("/findTop5ByPoints")
    public List<CarteFideliteResponse> findTop5ByPoints() {
        return carteFideliteService.findTop5ByPoints();
    }

    @PutMapping("/affecterCarteAClient/{idCarte}/{idClient}")
    public void affecterCarteAClient(@PathVariable long idCarte, @PathVariable long idClient) {
        carteFideliteService.affecterCarteAClient(idCarte, idClient);
    }

    @PutMapping("/desaffecter/{idCarte}/{idClient}")
    public void desaffecterCarteAClient(@PathVariable long idCarte,@PathVariable long idClient) {
        carteFideliteService.desaffecterCarteAClient(idClient, idCarte);
    }

}
