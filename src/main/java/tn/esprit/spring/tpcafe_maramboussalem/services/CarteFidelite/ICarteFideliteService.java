package tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite;

import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;

import java.time.LocalDate;
import java.util.List;

public interface ICarteFideliteService {
    CarteFideliteResponse addCarte(CarteFideliteRequest carteFideliteRequest);

    CarteFideliteResponse getCarteById(long id);
    List<CarteFideliteResponse> getAllCartes();

    CarteFideliteResponse updateCarte(long id, CarteFideliteRequest carteFideliteRequest);

    void deleteCarteById(long id);
    void deleteAllCartes();

    long countCartes();
    boolean verifCarteById(long id);

    List<CarteFideliteResponse> findByExactPoints(int points);
    List<CarteFideliteResponse> findByDateCreation(LocalDate date);
    long countByPointsGreater(int points);
    void deleteByDateBefore(LocalDate date);
    List<CarteFideliteResponse> findPointsBetweenAfterDate(int min, int max, LocalDate date);
    List<CarteFideliteResponse> findByPointsGreaterSortedByDate(int points);
    List<CarteFideliteResponse> findByDateBetween(LocalDate start, LocalDate end);
    List<CarteFideliteResponse> findPointsLessOrDateBefore(int points, LocalDate date);
    List<CarteFideliteResponse> findCarteWithMaxPoints();
    List<CarteFideliteResponse> findCarteNoDate();
    List<CarteFideliteResponse> findCartePointsNotNull();
    List<CarteFideliteResponse> findByClientNomPrenom(String nom, String prenom);
    List<CarteFideliteResponse> findTop5ByPoints();

    void affecterCarteAClient(long idCarte, long idClient);
    void desaffecterCarteAClient(long idClient, long idCarteFidelite);

}
