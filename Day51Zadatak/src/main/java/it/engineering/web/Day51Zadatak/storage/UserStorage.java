package it.engineering.web.Day51Zadatak.storage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.engineering.web.Day51Zadatak.domain.User;


public class UserStorage {
	private List<User> users;
	private List<User> loggedUsers;
	private static UserStorage instance;
	
	public UserStorage() {
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Day51Zadatak");
//		System.out.println("EMF");
//		
//		EntityManager em = emf.createEntityManager();
//		System.out.println("EM");
//		
//		List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
//		
//		System.out.println(users);
//		
//		em.close();
//		emf.close();

		
		users = new ArrayList() {
			{
				add(new User("user1", "user1"));
				add(new User("user2", "user2"));
				add(new User("user3", "user3"));
			}
		};
		
		loggedUsers = new ArrayList<>();
		
		
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
	
	public List<User> getLoggedUsers() {
		return loggedUsers;
	}
	
}
