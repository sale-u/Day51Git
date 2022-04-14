package it.engineering.web.Day51Zadatak.storage;

import java.util.ArrayList;
import java.util.List;

import it.engineering.web.Day51Zadatak.domain.User;


public class UserStorage {
	private List<User> users;
	private static UserStorage instance;
	
	public UserStorage() {
		users = new ArrayList() {
			{
				add(new User("user1", "user1"));
				add(new User("user2", "user2"));
				add(new User("user3", "user3"));
			}
		};
	}
	
	public static UserStorage getInstance() {
		if (instance == null) instance = new UserStorage();
		return instance;
	}
	
	public void add(User user) {
		users.add(user);
	}
		
	public List<User> getUsers() {
		return users;
	}
}
