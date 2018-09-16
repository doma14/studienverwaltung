package de.malbrich.studienverwaltung.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "semester")
@TableGenerator(name = "Semester")
public class Semester {

	@Id
	private String bezeichnung;

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
}
