package tn.esprit.spring.tpcafe_maramboussalem.services.Adresse;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseRequest;
import tn.esprit.spring.tpcafe_maramboussalem.dto.Adresse.AdresseResponse;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;
import tn.esprit.spring.tpcafe_maramboussalem.mapper.AdresseMapper;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.AdresseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdresseService implements IAdresseServices {

    AdresseRepository  adresseRepository;
    AdresseMapper adresseMapper;

    @Override
    public AdresseResponse addAdresse(AdresseRequest request) {
        Adresse adresse = adresseMapper.toEntity(request);
        Adresse saved = adresseRepository.save(adresse);
        return adresseMapper.toDto(saved);
    }

    @Override
    public AdresseResponse selectAdresseById(long id) {
        return adresseRepository.findById(id)
                .map(adresseMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Adresse introuvable"));
    }

    @Override
    public List<AdresseResponse> selectAllAdresses() {
        return adresseRepository.findAll()
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdresseResponse updateAdresse(long id, AdresseRequest request) {
        Adresse adresse = adresseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adresse introuvable"));

        adresse.setRue(request.getRue());
        adresse.setVille(request.getVille());
        adresse.setCodePostal(request.getCodePostal());

        Adresse updated = adresseRepository.save(adresse);
        return adresseMapper.toDto(updated);
    }

    @Override
    public void deleteAdresseById(long id) {
        adresseRepository.deleteById(id);
    }

    @Override
    public void deleteAllAdresses() {
        adresseRepository.deleteAll();
    }

    @Override
    public boolean verifAdresseById(long id) {
        return adresseRepository.existsById(id);
    }

    @Override
    public long countAdresses() {
        return adresseRepository.count();
    }
}
