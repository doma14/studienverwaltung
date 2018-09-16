package de.malbrich.studienverwaltung.entities.repositories;

import de.malbrich.studienverwaltung.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, String> {
}
