package it.engineering.web.Day51Zadatak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.actionfactory.ActionFactory;
import it.engineering.web.Day51Zadatak.constant.WebConstant;

public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		//iz request/a odrediti koji URL je korisnik zahtevao
		//konkretan URL mapirati na klasu koja je odgovorna da obradi taj URL
		String method = request.getMethod();
		String path = request.getPathInfo();
		
		System.out.println("METHOD: " + method);
		System.out.println("PATH: " + path);
		
		// Ne dozvoljava korisniku da samovoljno ide po stranicama (gadja prethodne URL putanje)
		// ukoliko se pre toga odjavio
		// Tako da ako je loginUser atribut sesije == null
		// i ako pokusa bilo koju akciju osim logovanja, onda ce ga sistem baciti na index.jsp
		System.out.println("Session loginUser = " + request.getSession().getAttribute("loginUser"));
		if (request.getSession().getAttribute("loginUser") == null && !path.equalsIgnoreCase(WebConstant.PATH_LOGIN)) {
			return WebConstant.PAGE_INDEX;
		}
		
		AbstractAction action = ActionFactory.createAction(method, path);
		//ToDo action = null;
		
		//vraca se stranica koju treba prikazati korisniku
		return action.executeRequest(request, response);
	}

}
