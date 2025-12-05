package tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.CarteFidelite.CarteFideliteResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Commande;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.CarteFideliteMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CarteFideliteRepository;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ClientRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarteFideliteService implements ICarteFideliteService {

    CarteFideliteRepository carteFideliteRepository;
    CarteFideliteMapper carteFideliteMapper;

    ClientRepository clientRepository;

    @Override
    public CarteFideliteResponse addCarte(CarteFideliteRequest request) {
        CarteFidelite carte = carteFideliteMapper.toEntity(request);
        CarteFidelite saved = carteFideliteRepository.save(carte);
        return carteFideliteMapper.toDto(saved);
    }

    @Override
    public CarteFideliteResponse getCarteById(long id) {
        CarteFidelite carte = carteFideliteRepository.findById(id).get();
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
        CarteFidelite carte = carteFideliteRepository.findById(id).get();

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

    @Override
    public List<CarteFideliteResponse> findByExactPoints(int points) {
        return carteFideliteRepository.findByPointsAccumules(points).stream()
                .map(carteFideliteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findByDateCreation(LocalDate date) {
        return carteFideliteRepository.findByDateCreation(date).stream()
                .map(carteFideliteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public long countByPointsGreater(int points) {
        return carteFideliteRepository.countByPointsAccumulesGreaterThan(points);
    }

    @Override
    public void deleteByDateBefore(LocalDate date) {
        carteFideliteRepository.deleteByDateCreationBefore(date);
    }

    @Override
    public List<CarteFideliteResponse> findPointsBetweenAfterDate(int min, int max, LocalDate date) {
        return carteFideliteRepository.findByPointsAccumulesBetweenAndDateCreationAfter(min, max, date)
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findByPointsGreaterSortedByDate(int points) {
        return carteFideliteRepository.findByPointsAccumulesGreaterThanEqualOrderByDateCreationAsc(points)
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findByDateBetween(LocalDate start, LocalDate end) {
        return carteFideliteRepository.findByDateCreationBetween(start, end)
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findPointsLessOrDateBefore(int points, LocalDate date) {
        return carteFideliteRepository.findByPointsLessThanOrDateCreationBefore(points, date)
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findCarteWithMaxPoints() {
        return carteFideliteRepository.findCarteWithMaxPoints()
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findCarteNoDate() {
        return carteFideliteRepository.findByDateCreationIsNull()
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findCartePointsNotNull() {
        return carteFideliteRepository.findByPointsAccumulesIsNotNull()
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findByClientNomPrenom(String nom, String prenom) {
        return carteFideliteRepository.findByClientNomAndPrenom(nom, prenom)
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CarteFideliteResponse> findTop5ByPoints() {
        return carteFideliteRepository.findTop5ByOrderByPointsAccumulesDesc()
                .stream().map(carteFideliteMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public void affecterCarteAClient(long idClient, long idCarteFidelite) {
        CarteFidelite carteFidelite = carteFideliteRepository.findById(idCarteFidelite).get();
        Client client = clientRepository.findById(idClient).get();
        client.getCartesFidelite().add(carteFidelite);
        clientRepository.save(client);
    }


    @Override
    public void desaffecterCarteAClient(long idClient, long idCarteFidelite) {
        CarteFidelite carteFidelite = carteFideliteRepository.findById(idCarteFidelite).get();
        Client client = clientRepository.findById(idClient).get();
        client.getCartesFidelite().remove(carteFidelite);
        clientRepository.save(client);
    }

}
