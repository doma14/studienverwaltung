package de.malbrich.studienverwaltung.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studienbrief")
@TableGenerator(name = "Studienbrief")
public class Studienbrief {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private boolean status;

	@Column
	private boolean statusUebungen;

	@Column
	private int nummer;

	@ManyToMany(targetEntity = Modul.class, mappedBy = "studienbriefe")
	private List<Modul> module;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatusUebungen() {
		return statusUebungen;
	}

	public void setStatusUebungen(boolean statusUebungen) {
		this.statusUebungen = statusUebungen;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public List<Modul> getModule() {
		return module;
	}

	public void setModule(List<Modul> module) {
		this.module = module;
	}
}
