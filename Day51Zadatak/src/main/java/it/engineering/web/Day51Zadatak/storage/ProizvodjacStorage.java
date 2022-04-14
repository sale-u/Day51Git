package it.engineering.web.Day51Zadatak.storage;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.Day51Zadatak.domain.Proizvodjac;

public class ProizvodjacStorage {
	
	private List<Proizvodjac> proizvodjaci;
	private static ProizvodjacStorage instance;
	
	public ProizvodjacStorage() {

		
		proizvodjaci = new ArrayList() {
			{
				add(new Proizvodjac(123456, 111111, "Kneza Mihajla 5", "Beograd"));
				add(new Proizvodjac(654321, 222222, "Kneza Milosa 15", "Beograd"));
				add(new Proizvodjac(564321, 333333, "Beogradska 10", "Nis"));
			}
		};
		
	}
	
	public static ProizvodjacStorage getInstance() {
		if (instance == null) instance = new ProizvodjacStorage();
		return instance;
	}
	
	public void add(Proizvodjac proizvodjac) {
		proizvodjaci.add(proizvodjac);
	}
		
	public List<Proizvodjac> getProizvodjaci() {
		return proizvodjaci;
	}

}
