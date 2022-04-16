package it.engineering.web.Day51Zadatak.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the city_table database table.
 * 
 */
@Entity
@Table(name="city_table")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="zip_code")
	private int zipCode;

	private String name;

	public City() {
	}
	
	

	public City(int zipCode, String name) {
		super();
		this.zipCode = zipCode;
		this.name = name;
	}



	public int getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + zipCode;
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
		City other = (City) obj;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "City [zipCode=" + zipCode + ", name=" + name + "]";
	}

	
	
}