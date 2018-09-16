package de.malbrich.studienverwaltung.entities.repositories;

import de.malbrich.studienverwaltung.entities.Praesenzveranstaltung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PraesenzveranstaltungRepository extends JpaRepository<Praesenzveranstaltung, Long> {
}
