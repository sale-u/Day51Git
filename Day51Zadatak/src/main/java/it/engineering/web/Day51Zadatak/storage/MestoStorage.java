package it.engineering.web.Day51Zadatak.storage;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.Day51Zadatak.domain.Mesto;

public class MestoStorage {
	
	private List<Mesto> mesta;
	private static MestoStorage instance;
	
	public MestoStorage() {

		
		mesta = new ArrayList() {
			{
				add(new Mesto(11000, "Beograd"));
				add(new Mesto(18000, "Nis"));
				add(new Mesto(37000, "Krusevac"));
			}	
		};
		
	}
	
	public static MestoStorage getInstance() {
		if (instance == null) instance = new MestoStorage();
		return instance;
	}
	
	public void add(Mesto mesto) {
		mesta.add(mesto);
	}
		
	public List<Mesto> getMesta() {
		return mesta;
	}

}
