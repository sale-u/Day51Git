package it.engineering.web.Day51Zadatak.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import it.engineering.web.Day51Zadatak.dao.CityDao;
import it.engineering.web.Day51Zadatak.domain.City;

public class JpaCityDaoImpl implements CityDao {
	private EntityManager em;
	
	public JpaCityDaoImpl(EntityManager em) {
		// EntityManager em se pravi u servisu
		this.em = em;
	}
	
	
	@Override
	public List<City> findAll() {

		return em.createNamedQuery("City.findAll").getResultList();
	}
	
	

}
