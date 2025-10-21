package tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.CarteFideliteRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CarteFideliteService implements ICarteFideliteService {
    public CarteFideliteRepository carteFideliteRepository;

    @Override
    public CarteFidelite addCarteFidelite(CarteFidelite carteFidelite){
        return carteFideliteRepository.save(carteFidelite);
    }

    @Override
    public List<CarteFidelite> saveCarteFidelite(List<CarteFidelite> carteFidelites){
        return carteFideliteRepository.saveAll(carteFidelites);
    }

    @Override
    public CarteFidelite selectCarteFideliteById(long id){
        return carteFideliteRepository.findById(id).get();
    }

    @Override
    public List<CarteFidelite> selectAllCarteFidelite(){
        return carteFideliteRepository.findAll();
    }

    @Override
    public void deleteCarteFidelite(CarteFidelite CarteFidelites){
        carteFideliteRepository.delete(CarteFidelites);
    }

    @Override
    public void deleteAllCarteFidelite(){
        carteFideliteRepository.deleteAll();
    }

    @Override
    public void deleteCarteFideliteById(long id){
        carteFideliteRepository.deleteById(id);
    }

    @Override
    public long countCarteFidelite(){
        return carteFideliteRepository.count();
    }

    @Override
    public boolean verifCarteFideliteById(long id){
        return carteFideliteRepository.existsById(id);
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithOrElse(long id) {
           CarteFidelite carteFidelite = CarteFidelite.builder()
                   .pointsAccumules(5).dateCreation(LocalDate.now())
                   .build();
           return carteFideliteRepository.findById(id).orElse(carteFidelite);
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithGet(long id) {
        return carteFideliteRepository.findById(id).get();
    }
}
