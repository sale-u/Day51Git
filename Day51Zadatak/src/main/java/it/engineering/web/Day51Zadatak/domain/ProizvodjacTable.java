package it.engineering.web.Day51Zadatak.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proizvodjac_table database table.
 * 
 */
@Entity
@Table(name="proizvodjac_table")
@NamedQuery(name="ProizvodjacTable.findAll", query="SELECT p FROM ProizvodjacTable p")
public class ProizvodjacTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pib;

	private String adresa;

	@Column(name="maticni_broj")
	private int maticniBroj;

	private String mesto;

	public ProizvodjacTable() {
	}
	
	

	public ProizvodjacTable(int pib, String adresa, int maticniBroj, String mesto) {
		super();
		this.pib = pib;
		this.adresa = adresa;
		this.maticniBroj = maticniBroj;
		this.mesto = mesto;
	}



	public int getPib() {
		return this.pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getMaticniBroj() {
		return this.maticniBroj;
	}

	public void setMaticniBroj(int maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	@Override
	public String toString() {
		return "ProizvodjacTable [pib=" + pib + ", adresa=" + adresa + ", maticniBroj=" + maticniBroj + ", mesto="
				+ mesto + "]";
	}

	
}