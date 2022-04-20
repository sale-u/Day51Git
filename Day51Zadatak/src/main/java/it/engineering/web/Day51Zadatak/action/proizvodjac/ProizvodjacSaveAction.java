package it.engineering.web.Day51Zadatak.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.City;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.service.CityService;
import it.engineering.web.Day51Zadatak.service.ProizvodjacService;
import it.engineering.web.Day51Zadatak.service.impl.CityServiceImpl;
import it.engineering.web.Day51Zadatak.service.impl.ProizvodjacServiceImpl;

public class ProizvodjacSaveAction extends AbstractAction {
	
	// SAVE (Sacuvaj izmene) nakon izmena na postojecem proizvodjacu
	// zove ga proizvodjac-confirm-edit.jsp
	
	private ProizvodjacService ps;
	private CityService cs;
	
	public ProizvodjacSaveAction() {
		ps = new ProizvodjacServiceImpl();
		cs = new CityServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		String pib = request.getParameter("pib");
		String matBr = request.getParameter("matbr");
		String adresa = request.getParameter("adresa");		
		String mesto = request.getParameter("mesto");		// <input vraca mesto koje se sastoji od zipCode i naziva
		// pa izdvajamo samo zipCode (prvih 5 karaktera)
		String zipCode = mesto.substring(0, mesto.indexOf(" "));
		System.out.println("zipCode = *" + zipCode + "*");
		
		if (request.getParameter("dugme").equalsIgnoreCase("cancel")) {
			// pritisnuto je cancel dugme pa se vracamo na listu
			
			List<Proizvodjac> proizvodjaci = ps.getProizvodjaci();
			request.setAttribute("proizvodjaci", proizvodjaci);
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
		// Korisnik je odobrio da se ova izmena sacuva (dugme "Potvrdi")
		
		City city = cs.findByZipCode(Integer.parseInt(zipCode));
		System.out.println("Nadjen city=" + city);

		updateProizvodjac(pib, matBr, adresa, city);
		
		request.setAttribute("proizvodjaci", ps.getProizvodjaci());
		// pa se vracamo na listu
		return WebConstant.PAGE_PROIZVODJACI;
	}
	
	private void updateProizvodjac(String pib, String matBr, String adresa, City city) {
		
		Proizvodjac modProizvodjac = new Proizvodjac(pib, matBr, adresa, city);
		ps.saveOrUpdate(modProizvodjac);
		
	}

}
