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




    @GetMapping("/points/exact/{points}")
    public List<CarteFideliteResponse> findByExactPoints(@PathVariable int points) {
        return carteFideliteService.findByExactPoints(points);
    }

    @GetMapping("/date/{date}")
    public List<CarteFideliteResponse> findByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return carteFideliteService.findByDateCreation(date);
    }

    @GetMapping("/count/pointsGreater/{points}")
    public long countByPointsGreater(@PathVariable int points) {
        return carteFideliteService.countByPointsGreater(points);
    }

    @DeleteMapping("/deleteBefore/{date}")
    public void deleteByDateBefore(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        carteFideliteService.deleteByDateBefore(date);
    }

    @GetMapping("/pointsBetweenAfterDate")
    public List<CarteFideliteResponse> findPointsBetweenAfterDate(@RequestParam int min, @RequestParam int max,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return carteFideliteService.findPointsBetweenAfterDate(min, max, date);
    }

    @GetMapping("/pointsGreaterSorted/{points}")
    public List<CarteFideliteResponse> findPointsGreaterSorted(@PathVariable int points) {
        return carteFideliteService.findByPointsGreaterSortedByDate(points);
    }

    @GetMapping("/dateBetween")
    public List<CarteFideliteResponse> findDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return carteFideliteService.findByDateBetween(start, end);
    }

    @GetMapping("/pointsLessOrDateBefore")
    public List<CarteFideliteResponse> findPointsLessOrDateBefore(
            @RequestParam int points,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return carteFideliteService.findPointsLessOrDateBefore(points, date);
    }

    @GetMapping("/maxPoints")
    public List<CarteFideliteResponse> findCarteWithMaxPoints() {
        return carteFideliteService.findCarteWithMaxPoints();
    }

    @GetMapping("/noDate")
    public List<CarteFideliteResponse> findCarteNoDate() {
        return carteFideliteService.findCarteNoDate();
    }

    @GetMapping("/pointsNotNull")
    public List<CarteFideliteResponse> findCartePointsNotNull() {
        return carteFideliteService.findCartePointsNotNull();
    }

    @GetMapping("/client")
    public List<CarteFideliteResponse> findByClientNomPrenom(@RequestParam String nom, @RequestParam String prenom) {
        return carteFideliteService.findByClientNomPrenom(nom, prenom);
    }

    @GetMapping("/top5")
    public List<CarteFideliteResponse> findTop5ByPoints() {
        return carteFideliteService.findTop5ByPoints();
    }
}
