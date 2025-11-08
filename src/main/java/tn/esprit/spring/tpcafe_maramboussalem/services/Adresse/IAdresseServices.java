package tn.esprit.spring.tpcafe_maramboussalem.services.Adresse;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import java.util.List;

public interface IAdresseServices {

    AdresseResponse addAdresse(AdresseRequest adresseRequest);

    AdresseResponse selectAdresseById(long id);
    List<AdresseResponse> selectAllAdresses();

    AdresseResponse updateAdresse(long id, AdresseRequest adresseRequest);

    void deleteAdresseById(long id);
    void deleteAllAdresses();

    boolean verifAdresseById(long id);
    long countAdresses();

}
