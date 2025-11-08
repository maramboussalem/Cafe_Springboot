package tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.CarteFideliteMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CarteFideliteRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarteFideliteService implements ICarteFideliteService {

    CarteFideliteRepository carteFideliteRepository;
    CarteFideliteMapper carteFideliteMapper;

    @Override
    public CarteFideliteResponse addCarte(CarteFideliteRequest request) {
        CarteFidelite carte = carteFideliteMapper.toEntity(request);
        CarteFidelite saved = carteFideliteRepository.save(carte);
        return carteFideliteMapper.toDto(saved);
    }

    @Override
    public CarteFideliteResponse getCarteById(long id) {
        CarteFidelite carte = carteFideliteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte fidélité introuvable : " + id));
        return carteFideliteMapper.toDto(carte);
    }

    @Override
    public List<CarteFideliteResponse> getAllCartes() {
        return carteFideliteRepository.findAll()
                .stream()
                .map(carteFideliteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarteFideliteResponse updateCarte(long id, CarteFideliteRequest request) {
        CarteFidelite carte = carteFideliteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte fidélité introuvable : " + id));

        carte.setPointsAccumules(request.getPointsAccumules());
        carte.setDateCreation(request.getDateCreation());

        CarteFidelite updated = carteFideliteRepository.save(carte);
        return carteFideliteMapper.toDto(updated);
    }

    @Override
    public void deleteCarteById(long id) {
        carteFideliteRepository.deleteById(id);
    }

    @Override
    public void deleteAllCartes() {
        carteFideliteRepository.deleteAll();
    }

    @Override
    public long countCartes() {
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifCarteById(long id) {
        return carteFideliteRepository.existsById(id);
    }
}
