package it.engineering.web.Day51Zadatak.domain;

public class Mesto {
	
	private int pttBroj;
	private String naziv;
	
	public Mesto() {
	}

	public Mesto(int pttBroj, String naziv) {
		super();
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}

	public int getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pttBroj;
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
		Mesto other = (Mesto) obj;
		if (pttBroj != other.pttBroj)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mesto [pttBroj=" + pttBroj + ", naziv=" + naziv + "]";
	}
	
}
