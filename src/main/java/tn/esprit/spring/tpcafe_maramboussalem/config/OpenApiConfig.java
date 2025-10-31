package tn.esprit.spring.tpcafe_maramboussalem.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TPCafe Maram BOUSSALEM")           // NOM DU PROJET
                        .contact(new Contact()
                                .name("Linkedin")
                                .url("https://www.linkedin.com/in/maram-boussalem-3212b9386/")  // LIEN LINKEDIN
                        )
                        .license(new License()
                                .name("GitHub")
                                .url("https://github.com/maramboussalem")  // LIEN GITHUB
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Code source complet")
                        .url("https://github.com/maramboussalem/spring-boot")     // LIEN GITHUB (encore)
                );
    }
}


