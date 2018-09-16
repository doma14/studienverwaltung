package de.malbrich.studienverwaltung.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "klausur")
@TableGenerator(name = "Klausur")
public class Klausur {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String ort;

	@Column
	@DateTimeFormat
	private Date datum;

	@Column
	private int note;

	@ManyToMany(targetEntity = Modul.class, mappedBy = "klausuren")
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

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public List<Modul> getModule() {
		return module;
	}

	public void setModule(List<Modul> module) {
		this.module = module;
	}
}
