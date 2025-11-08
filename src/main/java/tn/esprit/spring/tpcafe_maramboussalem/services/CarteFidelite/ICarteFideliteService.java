package tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite;

import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;

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
}
