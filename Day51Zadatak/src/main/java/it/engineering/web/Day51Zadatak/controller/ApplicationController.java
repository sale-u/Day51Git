package it.engineering.web.Day51Zadatak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.actionfactory.ActionFactory;

public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		//iz request/a odrediti koji URL je korisnik zahtevao
		//konkretan URL mapirati na klasu koja je odgovorna da obradi taj URL
		String method = request.getMethod();
		String path = request.getPathInfo();
		
		System.out.println("METHOD: " + method);
		System.out.println("PATH: " + path);
		
		AbstractAction action = ActionFactory.createAction(method, path);
		//ToDo action = null;
		
		//vraca se stranica koju treba prikazati korisniku
		return action.executeRequest(request, response);
	}

}
