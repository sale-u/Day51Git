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


public class ProizvodjacAddSaveAction extends AbstractAction {
	
	private ProizvodjacService ps;
	private CityService cs;
	
	public ProizvodjacAddSaveAction() {
		ps = new ProizvodjacServiceImpl();
		cs = new CityServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		String pib = request.getParameter("pib");
		String matBr = request.getParameter("matbr");
		String adresa = request.getParameter("adresa");		
		String zipCode = request.getParameter("zipCode");
		
		if (request.getParameter("dugme").equalsIgnoreCase("cancel")) {
			// pritisnuto je cancel dugme pa se vracamo na listu
			
			List<Proizvodjac> proizvodjaci = ps.getProizvodjaci();
			request.setAttribute("proizvodjaci", proizvodjaci);
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
		// Korisnik je odobrio da se ova izmena sacuva
		
		// provera da li je uneo sve cifre u pib i matBr
		String regex = "[0-9]+";
		if (!pib.matches(regex)) {
			request.setAttribute("error_message", "PIB mora da se sastoji iskljucivo iz brojeva");
			request.setAttribute("cities", cs.getCities());
			return WebConstant.PAGE_PROIZVODJAC_ADD;
		}
		if (!matBr.matches(regex)) {
			request.setAttribute("error_message", "Maticni broj mora da se sastoji iskljucivo iz brojeva");
			request.setAttribute("cities", cs.getCities());
			return WebConstant.PAGE_PROIZVODJAC_ADD;
		}
		
		
		City city = cs.findByZipCode(Integer.parseInt(zipCode));
		System.out.println("Nadjen city=" + city);

		Proizvodjac newP = addProizvodjac(pib, matBr, adresa, city);
		
		if (newP == null) {
			// vec postoji takav -> ne moze
			request.setAttribute("error_message", "Takav vec postoji - pokusajte ponovo");
			request.setAttribute("cities", cs.getCities());
			return WebConstant.PAGE_PROIZVODJAC_ADD;
		}
		
		request.setAttribute("proizvodjaci", ps.getProizvodjaci());
		// pa se vracamo na listu
		return WebConstant.PAGE_PROIZVODJACI;
	}

	private Proizvodjac addProizvodjac(String pib, String matBr, String adresa, City city) {

		List<Proizvodjac> proizvodjaci = ps.getProizvodjaci();
		
		Proizvodjac newP = new Proizvodjac(pib, matBr, adresa, city);
		
		// equals metoda iz Proizvodjac klase poredi samo pib polje
		if (proizvodjaci.contains(newP)) {
			// vec postoji takav -> ne moze
			return null;
			
		} else {
			ps.saveOrUpdate(newP);
			return newP;
			
		}	
		
	}

}
