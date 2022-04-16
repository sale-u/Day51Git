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
import it.engineering.web.Day51Zadatak.storage.ProizvodjacStorage;


public class ProizvodjacDeleteAction extends AbstractAction {
	
	private ProizvodjacService ps;
	private CityService cs;
	
	public ProizvodjacDeleteAction() {
		ps = new ProizvodjacServiceImpl();
		cs = new CityServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		String pib = request.getParameter("pib");
		
//		if (request.getParameter("dugme").equalsIgnoreCase("cancel")) {
//			// pritisnuto je cancel dugme pa se vracamo na listu
//			
//			List<Proizvodjac> proizvodjaci = ps.getProizvodjaci();
//			request.setAttribute("proizvodjaci", proizvodjaci);
//			return WebConstant.PAGE_PROIZVODJACI;
//		}
		
		Proizvodjac zaBrisanje = ps.deleteByPib(pib);
		
		if (zaBrisanje != null) {
			System.out.println("Uspesno obrisan = " + zaBrisanje);
		}
		
		request.setAttribute("proizvodjaci", ps.getProizvodjaci());
		// pa se vracamo na listu
		return WebConstant.PAGE_PROIZVODJACI;
	}

}
