package de.malbrich.studienverwaltung.controller;

import de.malbrich.studienverwaltung.entities.Semester;
import de.malbrich.studienverwaltung.entities.repositories.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

	@Autowired
	private SemesterRepository semesterRepository;

    @RequestMapping("/")
    public String index() {

		Semester semester = new Semester();
		semester.setBezeichnung("WS2018/2019");
		semesterRepository.save(semester);

		semesterRepository.flush();

		List<Semester> alleSemester = semesterRepository.findAll();
		for (Semester s : alleSemester) {
			System.out.println(s.getBezeichnung());
		}

        return "Greetings from Spring Boot!";
    }
}
