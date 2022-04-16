package it.engineering.web.Day51Zadatak.dao;

import java.util.List;

import it.engineering.web.Day51Zadatak.domain.Proizvodjac;

public interface ProizvodjacDao {
	
	List<Proizvodjac> findAll();
	
	Proizvodjac findByPib(String pib);
	
	Proizvodjac saveOrUpdate(Proizvodjac proizvodjac);
	
	Proizvodjac delete(Proizvodjac proizvodjac);

}
