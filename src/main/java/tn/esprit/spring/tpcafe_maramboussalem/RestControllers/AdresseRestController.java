package tn.esprit.spring.tpcafe_maramboussalem.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Adresse;
import tn.esprit.spring.tpcafe_maramboussalem.services.Adresse.IAdresseServices;
import java.util.List;

@RestController
@RequestMapping("adresse")
@AllArgsConstructor
public class AdresseRestController {

    private IAdresseServices adresseServices;

    @GetMapping
    public List<Adresse> selectAllAdresses() {
         return adresseServices.selectAllAdresses();
    }
}
