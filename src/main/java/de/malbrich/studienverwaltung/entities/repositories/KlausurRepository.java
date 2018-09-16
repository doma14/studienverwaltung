package de.malbrich.studienverwaltung.entities.repositories;

import de.malbrich.studienverwaltung.entities.Klausur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlausurRepository extends JpaRepository<Klausur, Long> {
}
