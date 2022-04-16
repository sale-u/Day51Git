package it.engineering.web.Day51Zadatak.dao;

import java.util.List;

import it.engineering.web.Day51Zadatak.domain.User;

public interface UserDao {
	
	List<User> findAll();

}
