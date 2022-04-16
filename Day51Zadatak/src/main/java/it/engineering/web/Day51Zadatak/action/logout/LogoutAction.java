package it.engineering.web.Day51Zadatak.action.logout;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.sessions.Session;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.User;
import it.engineering.web.Day51Zadatak.storage.UserStorage;

public class LogoutAction extends AbstractAction{

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// treba loginUser-a izbaciti iz sesije i iz liste logovanih
		
		HttpSession session = request.getSession();
		
		List<User> loggedUsers = UserStorage.getInstance().getLoggedUsers();
		
		User loginUser = (User) session.getAttribute("loginUser"); // Vraca mi dobrog usera iz sesije tek kada radi incognito browser
		
		System.out.println("Session LoginUser=" + loginUser);
		for (User u : loggedUsers) {
			if (loginUser.getUsername().equalsIgnoreCase(u.getUsername())) {
				loggedUsers.remove(u);
				break;
			}
		}
		System.out.println(loggedUsers);

		
		session.removeAttribute("loginUser"); 	// sklanjamo atribut "loginUser"
		session.invalidate();					// proglasava sesiju invalidnom i raskida njenu vezu sa ostalim objektima
		session = request.getSession(false);	// vraca null
			
		return WebConstant.PAGE_INDEX;			// vraca se na index.jsp
	}
	
	

}
