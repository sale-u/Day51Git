package it.engineering.web.Day51Zadatak.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import it.engineering.web.Day51Zadatak.dao.UserDao;
import it.engineering.web.Day51Zadatak.domain.User;

public class JpaUserDaoImpl implements UserDao {
	private EntityManager em;
	
	// ne pravi EntityManager em vec ga povlaci napravljenog iz UserServiceImpl koji poziva ovu klasu JpaUserDaoImpl
	public JpaUserDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<User> findAll() { 
		// putem querija vadi sve usere iz baze
		return em.createNamedQuery("User.findAll").getResultList();
	}
	
	

}
