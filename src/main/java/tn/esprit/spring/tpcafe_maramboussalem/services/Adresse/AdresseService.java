package tn.esprit.spring.tpcafe_maramboussalem.services.Adresse;

import jakarta.transaction.Transactional;
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
    public List<AdresseResponse> saveAdresses(List<AdresseRequest> requests) {
        List<Adresse> adresses = requests.stream()
                .map(adresseMapper::toEntity)
                .collect(Collectors.toList());

        List<Adresse> saved = adresseRepository.saveAll(adresses);
        return saved.stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }
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



    @Override
    public List<AdresseResponse> findByVille(String ville) {
        return adresseRepository.findByVille(ville)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostal(Integer codePostal) {
        return adresseRepository.findByCodePostal(codePostal)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public long countByVille(String ville) {
        return adresseRepository.countByVille(ville);
    }

    @Override
    @Transactional // ⚠️ Ajouté pour deleteByVille
    public void deleteByVille(String ville) {
        adresseRepository.deleteByVille(ville);
    }

    @Override
    public List<AdresseResponse> findByVilleAndCodePostal(String ville, Integer codePostal) {
        return adresseRepository.findByVilleAndCodePostal(ville, codePostal)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueContainingIgnoreCaseAndVille(String motRue, String ville) {
        return adresseRepository.findByRueIgnoreCaseContainingAndVilleIgnoreCase(motRue, ville)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByVilleIn(List<String> villes) {
        return adresseRepository.findByVilleIn(villes)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalBetween(Integer min, Integer max) {
        return adresseRepository.findByCodePostalBetween(min, max)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalGreaterThan(Integer cp) {
        return adresseRepository.findByCodePostalGreaterThan(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalGreaterThanEqual(Integer cp) {
        return adresseRepository.findByCodePostalGreaterThanEqual(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalLessThan(Integer cp) {
        return adresseRepository.findByCodePostalLessThan(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByCodePostalLessThanEqual(Integer cp) {
        return adresseRepository.findByCodePostalLessThanEqual(cp)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueStartsWithAndVille(String prefix, String ville) {
        return adresseRepository.findByRueStartsWithAndVilleOrderByCodePostal(prefix, ville)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueStartsWith(String prefix) {
        return adresseRepository.findByRueStartsWith(prefix)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByVilleEndsWith(String suffix) {
        return adresseRepository.findByVilleEndsWith(suffix)
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByRueIsNull() {
        return adresseRepository.findByRueIsNull()
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdresseResponse> findByVilleIsNotNull() {
        return adresseRepository.findByVilleIsNotNull()
                .stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

}
