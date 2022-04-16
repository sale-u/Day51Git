package it.engineering.web.Day51Zadatak.service;

import java.util.List;

import it.engineering.web.Day51Zadatak.domain.Proizvodjac;

public interface ProizvodjacService {
	
	List<Proizvodjac> getProizvodjaci();
	
	Proizvodjac findByPib(String pib);
	
	Proizvodjac saveOrUpdate(Proizvodjac proizvodjac);
	
	Proizvodjac deleteByPib(String pib);

}
