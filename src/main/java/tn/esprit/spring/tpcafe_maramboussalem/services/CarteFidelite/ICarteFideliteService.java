package tn.esprit.spring.tpcafe_maramboussalem.services.CarteFidelite;

import tn.esprit.spring.tpcafe_maramboussalem.entities.CarteFidelite;

import java.util.List;

public interface ICarteFideliteService {
    CarteFidelite addCarteFidelite(CarteFidelite carteFidelite);
    List<CarteFidelite> saveCarteFidelite(List<CarteFidelite> carteFidelites);
    CarteFidelite selectCarteFideliteById(long id);
    List<CarteFidelite> selectAllCarteFidelite();
    void deleteCarteFidelite(CarteFidelite CarteFidelites);
    void deleteAllCarteFidelite();
    void deleteCarteFideliteById(long id);
    long countCarteFidelite();
    boolean verifCarteFideliteById(long id);
    CarteFidelite selectCarteFideliteByIdWithOrElse(long id) ;
    CarteFidelite selectCarteFideliteByIdWithGet(long id) ;
}
