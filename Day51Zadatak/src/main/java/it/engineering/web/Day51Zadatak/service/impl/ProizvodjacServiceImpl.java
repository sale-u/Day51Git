package it.engineering.web.Day51Zadatak.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import it.engineering.web.Day51Zadatak.dao.ProizvodjacDao;
import it.engineering.web.Day51Zadatak.dao.impl.JpaProizvodjacDaoImpl;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.service.ProizvodjacService;

public class ProizvodjacServiceImpl implements ProizvodjacService{
	private EntityManager em;
	private ProizvodjacDao proizvodjacDao;

	public ProizvodjacServiceImpl() {
		em = Persistence.createEntityManagerFactory("Day51Zadatak").createEntityManager();
		proizvodjacDao = new JpaProizvodjacDaoImpl(em);
	}
	
	@Override
	public List<Proizvodjac> getProizvodjaci() {
		return proizvodjacDao.findAll();
	}

	@Override
	public Proizvodjac findByPib(String pib) {
		return proizvodjacDao.findByPib(pib);
	}

	@Override
	public Proizvodjac saveOrUpdate(Proizvodjac proizvodjac) {
		Proizvodjac sacuvaniProizvodjac = proizvodjacDao.saveOrUpdate(proizvodjac);
		
		System.out.println("Sacuvan ili updateovan proizvodjac = " + sacuvaniProizvodjac);
		
		return sacuvaniProizvodjac;
		
	}

	@Override
	public Proizvodjac deleteByPib(String pib) {

		Proizvodjac zaBrisanje = findByPib(pib);
		if (zaBrisanje != null) {
			proizvodjacDao.delete(zaBrisanje);
			return zaBrisanje;
		}
		return null;
	}
	
}
