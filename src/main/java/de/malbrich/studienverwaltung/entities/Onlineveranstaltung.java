package de.malbrich.studienverwaltung.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "onlineveranstaltung")
@TableGenerator(name = "Onlineveranstaltung")
public class Onlineveranstaltung {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String link;

	@Column
	@DateTimeFormat
	private Date zeit;

	@ManyToMany(targetEntity = Modul.class, mappedBy = "onlineveranstaltungen")
	private List<Modul> module;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getZeit() {
		return zeit;
	}

	public void setZeit(Date zeit) {
		this.zeit = zeit;
	}

	public List<Modul> getModule() {
		return module;
	}

	public void setModule(List<Modul> module) {
		this.module = module;
	}
}
