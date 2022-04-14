package it.engineering.web.Day51Zadatak.action.login;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.User;
import it.engineering.web.Day51Zadatak.persistence.MyEntityManagerFactory;
import it.engineering.web.Day51Zadatak.storage.UserStorage;

public class LoginPostAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		User user = login(request);
		
		if (user!=null) {
			
			// da li je vec logovan?
			List<User> loggedUsers = UserStorage.getInstance().getLoggedUsers();
			if (loggedUsers.contains(user)) {
				// vec je logovan
				request.setAttribute("error_message", "Korisnik je vec logovan!");
				return WebConstant.PAGE_LOGIN;				
			}
			// nije logovan, dodati ga u listu logovanih
			loggedUsers.add(user);
			System.out.println(loggedUsers);
			
			HttpSession session = request.getSession(true);
			
			//postojeci korisnik sistema ima password, napravi novog bez password-a
			User loginUser  = user.clone();
			//user.setPassword(null);
			session.setAttribute("loginUser", loginUser);
			return WebConstant.PAGE_HOME;
		}else {
			//ubaciti poruku za korisnika
			request.setAttribute("error_message", "Korisnik ne postoji!");
			return WebConstant.PAGE_LOGIN;
		}
	}

	private User login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
//		List<User> users = em.createQuery("select u from User u", User.class).getResultList();
//		em.close();
		
		
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		List<User> users = UserStorage.getInstance().getUsers();
		
		for (User current : users) {
			if (current.equals(user)) return current;
		}
		
		return null;
	}
	
	

}
