package it.engineering.web.Day51Zadatak.action.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.User;
import it.engineering.web.Day51Zadatak.storage.UserStorage;

public class LoginPostAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		User user = login(request);
		
		if (user!=null) {
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
