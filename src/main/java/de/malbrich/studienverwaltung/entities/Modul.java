package de.malbrich.studienverwaltung.entities;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "modul")
@TableGenerator(name = "Modul")
public class Modul {

	@Id
	@GeneratedValue
	private long id;

	@Column
	@UniqueElements
	private String bezeichnung;

	@Column
	private String professor;

	@Column
	private String tutor;

	@Column
	private String uni;

	@OneToMany(targetEntity = Semester.class)
	private List<Semester> semester;

	@ManyToMany(targetEntity = Klausur.class, cascade = CascadeType.ALL)
	@JoinTable(name = "modul_klausur", schema = "public",
			joinColumns = @JoinColumn(name = "modul_id"),
			inverseJoinColumns = @JoinColumn(name = "klausur_id"))
	private List<Klausur> klausuren;

	@ManyToMany(targetEntity = Studienbrief.class, cascade = CascadeType.ALL)
	@JoinTable(name = "modul_studienbrief", schema = "public",
			joinColumns = @JoinColumn(name = "modul_id"),
			inverseJoinColumns = @JoinColumn(name = "studienbrief_id"))
	private List<Studienbrief> studienbriefe;

	@ManyToMany(targetEntity = Onlineveranstaltung.class, cascade = CascadeType.ALL)
	@JoinTable(name = "modul_onlineveranstaltung", schema = "public",
			joinColumns = @JoinColumn(name = "modul_id"),
			inverseJoinColumns = @JoinColumn(name = "onlineveranstaltung_id"))
	private List<Onlineveranstaltung> onlineveranstaltungen;

	@ManyToMany(targetEntity = Praesenzveranstaltung.class, cascade = CascadeType.ALL)
	@JoinTable(name = "modul_praesenzveranstaltung", schema = "public",
			joinColumns = @JoinColumn(name = "modul_id"),
			inverseJoinColumns = @JoinColumn(name = "praesenzveranstaltung_id"))
	private List<Praesenzveranstaltung> praesenzveranstaltungen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

	public List<Semester> getSemester() {
		return semester;
	}

	public void setSemester(List<Semester> semester) {
		this.semester = semester;
	}

	public List<Klausur> getKlausuren() {
		return klausuren;
	}

	public void setKlausuren(List<Klausur> klausuren) {
		this.klausuren = klausuren;
	}

	public List<Studienbrief> getStudienbriefe() {
		return studienbriefe;
	}

	public void setStudienbriefe(List<Studienbrief> studienbriefe) {
		this.studienbriefe = studienbriefe;
	}

	public List<Onlineveranstaltung> getOnlineveranstaltungen() {
		return onlineveranstaltungen;
	}

	public void setOnlineveranstaltungen(List<Onlineveranstaltung> onlineveranstaltungen) {
		this.onlineveranstaltungen = onlineveranstaltungen;
	}

	public List<Praesenzveranstaltung> getPraesenzveranstaltungen() {
		return praesenzveranstaltungen;
	}

	public void setPraesenzveranstaltungen(List<Praesenzveranstaltung> praesenzveranstaltungen) {
		this.praesenzveranstaltungen = praesenzveranstaltungen;
	}
}
