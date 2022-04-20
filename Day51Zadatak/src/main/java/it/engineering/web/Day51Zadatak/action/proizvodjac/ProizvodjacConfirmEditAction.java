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


public class ProizvodjacConfirmEditAction extends AbstractAction {
	
	// potvrda da li zaista editujemo proizvodjaca
	// zove ga dugme "Sacuvaj" sa proizvodjac_view.jsp
	// salje na proizvodjac-confirm-edit.jsp
	
	private ProizvodjacService ps;
	private CityService cs;
	
	public ProizvodjacConfirmEditAction() {
		ps = new ProizvodjacServiceImpl();
		cs = new CityServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		if (request.getParameter("dugme").equalsIgnoreCase("cancel")) {
			// pritisnuto je cancel dugme pa se vracamo na listu
			
			List<Proizvodjac> proizvodjaci = ps.getProizvodjaci();
			request.setAttribute("proizvodjaci", proizvodjaci);
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
		// idemo na stranicu potvrde editovanja proizvodjac-confirm-edit.jsp
		
		String pib = request.getParameter("pib");		// pib se ne moze menjati
		String matBr = request.getParameter("matbr");	// a ostalo moze
		String adresa = request.getParameter("adresa");
		String zipCode = request.getParameter("zipCode");
		
		// provera da li je uneo sve cifre u matBr
		String regex = "[0-9]+";
		if (!matBr.matches(regex)) {
			request.setAttribute("error_message", "Maticni broj mora da se sastoji iskljucivo iz brojeva");
			Proizvodjac p = ps.findByPib(pib);
			request.setAttribute("proizvodjac", p);
			request.setAttribute("cities", cs.getCities());
			return WebConstant.PAGE_PROIZVODJAC_VIEW;
		}
		
		City newCity = cs.findByZipCode(Integer.parseInt(zipCode));
		Proizvodjac newProizvodjac = new Proizvodjac(pib, matBr, adresa, newCity);
		
		// na stranici proizvodjac-confirm-edit.jsp ce prikazati nove vrednosti Proizvodjac parametara
		request.setAttribute("proizvodjac", newProizvodjac);
		return WebConstant.PAGE_PROIZVODJAC_SAVE_CONF;
	}

}
