package tn.esprit.spring.tpcafe_maramboussalem.schedular;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.tpcafe_maramboussalem.entities.Client;
import tn.esprit.spring.tpcafe_maramboussalem.repositories.ClientRepository;
import tn.esprit.spring.tpcafe_maramboussalem.services.Client.ClientService;
import tn.esprit.spring.tpcafe_maramboussalem.services.Promotion.PromotionService;

import java.time.LocalDate;
import java.util.List;

//Lombok : slf4J  TRCE(*) INTO DEBUG WARN ERROR FATAL
@Component
@AllArgsConstructor
@Slf4j
public class SchedularMethodes {

   private ClientService clientService;

   private PromotionService promotionService;

    //FixeDate(ms) FixeDelay(ms) cron( * * * * * * )
    @Scheduled(fixedRate = 2000)
    public void methode() {
        log.info("MethodefixedRate");
    }

    @Scheduled(fixedDelay = 2000)
    public void methode1() {
        log.info("MethodefixedDelay");
    }

    @Scheduled(cron = "15 * * * * *")
    public void methode3() {
        log.info("MethodefixedDelay");
    }

    //1 a la seconde 17 de chaque seconde 08h30m15s/08h30m25s
    //2 chaque 15s 08h30m 1os(+15s) /08h30m 25s
    //3 il faut attendre jusqua s=0  08h31m0s/08h31m3os /45....

    @Scheduled(cron = "0 0 0 * * *")
    public void methode4() {
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void methode5() {
        log.info("Début affichage des articles en promotion pour le mois courant");
        promotionService.getArticlesEnPromotionPourMoisCourant();
        log.info("Fin affichage des promotions");
    }
}
