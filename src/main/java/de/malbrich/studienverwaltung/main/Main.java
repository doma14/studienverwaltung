package de.malbrich.studienverwaltung.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("de.malbrich.studienverwaltung")
@EnableJpaRepositories(basePackages = "de.malbrich.studienverwaltung.entities.repositories")
@EnableAutoConfiguration
@EntityScan(basePackages = "de.malbrich.studienverwaltung.entities")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
