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
		String zipCode = request.getParameter("zipCode");	
		
		if (request.getParameter("dugme").equalsIgnoreCase("cancel")) {
			// pritisnuto je cancel dugme pa se vracamo na listu
			
			List<Proizvodjac> proizvodjaci = ps.getProizvodjaci();
			request.setAttribute("proizvodjaci", proizvodjaci);
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
		// Korisnik je odobrio da se ova izmena sacuva (dugme "Sacuvaj izmene")
		
		// provera da li je uneo sve cifre u matBr
		String regex = "[0-9]+";
		if (!matBr.matches(regex)) {
			request.setAttribute("error_message", "Maticni broj mora da se sastoji iskljucivo iz brojeva");
			Proizvodjac p = ps.findByPib(pib);
			request.setAttribute("proizvodjac", p);
			request.setAttribute("cities", cs.getCities());
			return WebConstant.PAGE_PROIZVODJAC_VIEW;
		}
		
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

//		List<Proizvodjac> proizvodjaci = ProizvodjacStorage.getInstance().getProizvodjaci();
//		
//		for (Proizvodjac p : proizvodjaci) {
//			if (p.getPib() == pib) {
//				p.setMaticniBroj(matBr);
//				p.setAdresa(adresa);
//				p.setMesto(mesto);
//				// automatski su izmenjena polja clana liste
//				break;
//			}
//		}
		
	}

}
