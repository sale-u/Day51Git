package it.engineering.web.Day51Zadatak.service;

import it.engineering.web.Day51Zadatak.domain.User;

public interface UserService {
	
	User login(String username, String password);

}
