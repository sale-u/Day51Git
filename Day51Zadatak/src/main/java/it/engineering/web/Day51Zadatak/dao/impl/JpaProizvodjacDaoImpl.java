package it.engineering.web.Day51Zadatak.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.Day51Zadatak.dao.ProizvodjacDao;
import it.engineering.web.Day51Zadatak.domain.City;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;

public class JpaProizvodjacDaoImpl implements ProizvodjacDao {
	private EntityManager em;
	
	public JpaProizvodjacDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public List<Proizvodjac> findAll() {
		return em.createNamedQuery("Proizvodjac.findAll").getResultList();
	}

	@Override
	public Proizvodjac findByPib(String pib) {
		// vraca null ako ne nadje
		// ako nadje, vraca City objekat
		return em.find(Proizvodjac.class, pib);
	}
	
	
	@Override
	public Proizvodjac saveOrUpdate(Proizvodjac proizvodjac) {
		
		Proizvodjac sacuvaniProizvodjac = null;
		
		em.getTransaction().begin();
		sacuvaniProizvodjac = em.merge(proizvodjac);
		em.getTransaction().commit();
		
		return sacuvaniProizvodjac;
	}


	@Override
	public Proizvodjac delete(Proizvodjac proizvodjac) {
		
		Proizvodjac zaBrisanje = findByPib(proizvodjac.getPib());
		if (zaBrisanje != null) {
			em.getTransaction().begin();
			em.remove(zaBrisanje);
			em.getTransaction().commit();
			return zaBrisanje;
		}
		return null;
	}



	
	

}
