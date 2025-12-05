package tn.esprit.spring.tpcafe_maramboussalem.services.Adresse;

import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import java.util.List;

public interface IAdresseServices {

    List<AdresseResponse> saveAdresses(List<AdresseRequest> requests);
    AdresseResponse addAdresse(AdresseRequest adresseRequest);

    AdresseResponse selectAdresseById(long id);
    List<AdresseResponse> selectAllAdresses();

    AdresseResponse updateAdresse(long id, AdresseRequest adresseRequest);

    void deleteAdresseById(long id);
    void deleteAllAdresses();

    boolean verifAdresseById(long id);
    long countAdresses();


    // (Keywords)
    List<AdresseResponse> findByVille(String ville);
    List<AdresseResponse> findByCodePostal(Integer codePostal);
    long countByVille(String ville);
    void deleteByVille(String ville);
    List<AdresseResponse> findByVilleAndCodePostal(String ville, Integer codePostal);
    List<AdresseResponse> findByRueContainingIgnoreCaseAndVille(String motRue, String ville);
    List<AdresseResponse> findByVilleIn(List<String> villes);
    List<AdresseResponse> findByCodePostalBetween(Integer min, Integer max);
    List<AdresseResponse> findByCodePostalGreaterThan(Integer cp);
    List<AdresseResponse> findByCodePostalGreaterThanEqual(Integer cp);
    List<AdresseResponse> findByCodePostalLessThan(Integer cp);
    List<AdresseResponse> findByCodePostalLessThanEqual(Integer cp);
    List<AdresseResponse> findByRueStartsWithAndVille(String prefix, String ville);
    List<AdresseResponse> findByRueStartsWith(String prefix);
    List<AdresseResponse> findByVilleEndsWith(String suffix);
    List<AdresseResponse> findByRueIsNull();
    List<AdresseResponse> findByVilleIsNotNull();

}
