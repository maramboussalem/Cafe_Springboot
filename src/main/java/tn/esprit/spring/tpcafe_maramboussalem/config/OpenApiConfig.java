package tn.esprit.spring.tpcafe_maramboussalem.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TPCafe Maram BOUSSALEM")
                        .contact(new Contact()
                                .name("Linkedin")
                                .url("https://www.linkedin.com/in/maram-boussalem-3212b9386/")
                        )
                        .license(new License()
                                .name("GitHub")
                                .url("https://github.com/maramboussalem")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Code source complet")
                        .url("https://github.com/maramboussalem/spring-boot")
                );
    }

    @Bean
    public GroupedOpenApi allApisGroup() {
        return GroupedOpenApi.builder()
                .group("Tous")
                .pathsToMatch("/**")     // Tous les endpoints
                .build();
    }

    @Bean
    public GroupedOpenApi adresseGroup() {
        return GroupedOpenApi.builder()
                .group("Adresse")
                .pathsToMatch("/adresse/**")
                .build();
    }

    @Bean
    public GroupedOpenApi clientGroup() {
        return GroupedOpenApi.builder()
                .group("Client")
                .pathsToMatch("/client/**")
                .build();
    }

    @Bean
    public GroupedOpenApi commandeGroup() {
        return GroupedOpenApi.builder()
                .group("Commande")
                .pathsToMatch("/commande/**")
                .build();
    }

    @Bean
    public GroupedOpenApi articleGroup() {
        return GroupedOpenApi.builder()
                .group("Article")
                .pathsToMatch("/article/**")
                .build();
    }

    @Bean
    public GroupedOpenApi carteFideliteGroup() {
        return GroupedOpenApi.builder()
                .group("CarteFidelite")
                .pathsToMatch("/cartefidelite/**")
                .build();
    }

    @Bean
    public GroupedOpenApi detailCommandeGroup() {
        return GroupedOpenApi.builder()
                .group("DetailCommande")
                .pathsToMatch("/detailcommande/**")
                .build();
    }

    @Bean
    public GroupedOpenApi promotionGroup() {
        return GroupedOpenApi.builder()
                .group("Promotion")
                .pathsToMatch("/promotion/**")
                .build();
    }

}
