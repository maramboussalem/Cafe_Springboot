package tn.esprit.spring.tpcafe_maramboussalem.services.Adresse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.AdresseRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class AdresseService implements IAdresseServices{

    public AdresseRepository  adresseRepository;

    @Override
    public Adresse addAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public List<Adresse> saveAdresses(List<Adresse> adresses) {
        return adresseRepository.saveAll(adresses);
    }

    @Override
    public Adresse selectAdresseById(long id) {
        return adresseRepository.findById(id).get();
    }

    @Override
    public Adresse selectAdresseByIdWithGet(long id) {
       return adresseRepository.findById(id).get();
    }

    @Override
    public Adresse selectAdresseByIdWithOrElse(long id) {
        Adresse adresse = Adresse.builder()
                .rue("Ezzahra").ville("Tunis").codePostal(1000)
                .build();
        return adresseRepository.findById(id).orElse(adresse);
    }

    @Override
    public List<Adresse> selectAllAdresses() {
        return adresseRepository.findAll();
    }

    @Override
    public void deleteAdresse(Adresse adresse) {
         adresseRepository.delete(adresse);
    }

    @Override
    public void deleteAllAdresses() {
         adresseRepository.deleteAll();
    }

    @Override
    public void deleteAdresseById(long id) {
        adresseRepository.deleteById(id);
    }

    @Override
    public long countAdresses() {
        return adresseRepository.count();
    }

    @Override
    public boolean verifAdresseById(long id) {
        return adresseRepository.existsById(id);
    }

}
