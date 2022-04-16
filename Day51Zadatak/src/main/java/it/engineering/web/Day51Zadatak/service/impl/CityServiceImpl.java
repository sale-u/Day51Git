package it.engineering.web.Day51Zadatak.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import it.engineering.web.Day51Zadatak.dao.CityDao;
import it.engineering.web.Day51Zadatak.dao.impl.JpaCityDaoImpl;
import it.engineering.web.Day51Zadatak.domain.City;
import it.engineering.web.Day51Zadatak.service.CityService;

public class CityServiceImpl implements CityService {
	private EntityManager em;
	private CityDao cityDao;
	
	public CityServiceImpl() {
		em = Persistence.createEntityManagerFactory("Day51Zadatak").createEntityManager();
		cityDao = new JpaCityDaoImpl(em);
	}

	@Override
	public List<City> getCities() {
		return cityDao.findAll();
	}

}
