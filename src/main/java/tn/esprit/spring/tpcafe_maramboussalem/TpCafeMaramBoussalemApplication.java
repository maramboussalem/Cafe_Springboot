package tn.esprit.spring.tpcafe_maramboussalem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TpCafeMaramBoussalemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpCafeMaramBoussalemApplication.class, args);
	}

}
