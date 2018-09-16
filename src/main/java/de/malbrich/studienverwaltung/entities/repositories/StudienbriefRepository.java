package de.malbrich.studienverwaltung.entities.repositories;

import de.malbrich.studienverwaltung.entities.Studienbrief;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudienbriefRepository extends JpaRepository<Studienbrief, Long> {
}
