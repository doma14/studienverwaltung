package de.malbrich.studienverwaltung.entities.repositories;

import de.malbrich.studienverwaltung.entities.Modul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModulRepository extends JpaRepository<Modul, Long> {
}
