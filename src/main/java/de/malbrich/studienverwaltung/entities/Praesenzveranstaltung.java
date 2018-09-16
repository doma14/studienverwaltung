package de.malbrich.studienverwaltung.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "praesenzveranstaltung")
@TableGenerator(name = "Praesenzveranstaltung")
public class Praesenzveranstaltung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String ort;

	@Column
	private Date datum;

	@ManyToMany(targetEntity = Modul.class, mappedBy = "praesenzveranstaltungen")
	private List<Modul> module;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public List<Modul> getModule() {
		return module;
	}

	public void setModule(List<Modul> module) {
		this.module = module;
	}
}
