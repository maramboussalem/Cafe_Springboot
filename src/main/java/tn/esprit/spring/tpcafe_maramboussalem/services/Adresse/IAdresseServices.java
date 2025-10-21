package tn.esprit.spring.tpcafe_maramboussalem.services.Adresse;

import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;
import java.util.List;

public interface IAdresseServices {

    Adresse addAdresse(Adresse adresse);
    List<Adresse> saveAdresses(List<Adresse> adresses);
    Adresse selectAdresseById(long id);
    List<Adresse>selectAllAdresses();
    void deleteAdresse(Adresse adresse);
    void deleteAllAdresses();
    void deleteAdresseById(long id);
    long countAdresses();
    boolean verifAdresseById(long id);
    Adresse selectAdresseByIdWithOrElse(long id) ;
    Adresse selectAdresseByIdWithGet(long id) ;



}
