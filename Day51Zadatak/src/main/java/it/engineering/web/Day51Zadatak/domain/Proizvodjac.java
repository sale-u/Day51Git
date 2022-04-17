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
	private String pib;
	@Column(name="mat_br")
	private String matBr;
	private String adresa;
	
	@ManyToOne
	@JoinColumn(name = "zip_code_FK", referencedColumnName = "zip_code")
	private City city;

	public Proizvodjac() {
	}
	
	

	public Proizvodjac(String pib, String matBr, String adresa, City city) {
		super();
		this.pib = pib;
		this.matBr = matBr;
		this.adresa = adresa;
		this.city = city;
	}


	public String getPib() {
		return this.pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMatBr() {
		return this.matBr;
	}

	public void setMatBr(String matBr) {
		this.matBr = matBr;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pib == null) ? 0 : pib.hashCode());
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
		if (pib == null) {
			if (other.pib != null)
				return false;
		} else if (!pib.equals(other.pib))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Proizvodjac [pib=" + pib + ", matBr=" + matBr + ", adresa=" + adresa + ", city=" + city + "]";
	}


	
	
}