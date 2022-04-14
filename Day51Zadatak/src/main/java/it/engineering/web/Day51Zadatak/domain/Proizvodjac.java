package it.engineering.web.Day51Zadatak.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proizvodjac_table database table.
 * 
 */
@Entity
@Table(name="proizvodjac_table")
@NamedQuery(name="Proizvodjac.findAll", query="SELECT p FROM Proizvodjac p")
public class Proizvodjac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pib;
	private String adresa;
	
	@Column(name="maticni_broj")
	private int maticniBroj;
	private String mesto;
	

	public Proizvodjac() {
	}
	

	public Proizvodjac(int pib, int maticniBroj, String adresa, String mesto) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pib;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proizvodjac other = (Proizvodjac) obj;
		if (pib != other.pib)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ProizvodjacTable [pib=" + pib + ", adresa=" + adresa + ", maticniBroj=" + maticniBroj + ", mesto="
				+ mesto + "]";
	}

	
}