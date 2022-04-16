package it.engineering.web.Day51Zadatak.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import it.engineering.web.Day51Zadatak.dao.UserDao;
import it.engineering.web.Day51Zadatak.dao.impl.JpaUserDaoImpl;
import it.engineering.web.Day51Zadatak.domain.User;
import it.engineering.web.Day51Zadatak.service.UserService;

public class UserServiceImpl implements UserService {
	private EntityManager em;
	private UserDao userDao;
	
	public UserServiceImpl() {
		em = Persistence.createEntityManagerFactory("Day51Zadatak").createEntityManager();
		userDao = new JpaUserDaoImpl(em);
	}

	@Override
	public User login(String username, String password) {
		List<User> users = userDao.findAll();
		
		System.out.println(users);
		
		for (User u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	

}
