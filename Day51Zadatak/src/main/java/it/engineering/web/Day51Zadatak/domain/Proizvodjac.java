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

	private String adresa;

	@Column(name="mat_br")
	private String matBr;

	private int zip_code_FK;

	public Proizvodjac() {
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

	public int getZip_code_FK() {
		return this.zip_code_FK;
	}

	public void setZip_code_FK(int zip_code_FK) {
		this.zip_code_FK = zip_code_FK;
	}

}