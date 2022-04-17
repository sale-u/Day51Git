package it.engineering.web.Day51Zadatak.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.service.ProizvodjacService;
import it.engineering.web.Day51Zadatak.service.impl.ProizvodjacServiceImpl;


public class ProizvodjacDeleteAction extends AbstractAction {
	
	// Vrsi brisanje proizvodjaca po parametru pib iz baze
	// poziva ga proizvodjac-confirm-del.jsp
	// a nakon brisanja se vraca na proizvodjaci.jsp
	
	private ProizvodjacService ps;
	
	public ProizvodjacDeleteAction() {
		ps = new ProizvodjacServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		String pib = request.getParameter("pib");
		
		if (request.getParameter("dugme").equalsIgnoreCase("cancel")) {
			// pritisnuto je cancel dugme pa se vracamo na listu
			
			List<Proizvodjac> proizvodjaci = ps.getProizvodjaci();
			request.setAttribute("proizvodjaci", proizvodjaci);
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
		// odobreno je brisanje!
		
		Proizvodjac zaBrisanje = ps.deleteByPib(pib);
		
		if (zaBrisanje != null) {
			System.out.println("Uspesno obrisan = " + zaBrisanje);
		}
		
		request.setAttribute("proizvodjaci", ps.getProizvodjaci());
		// pa se vracamo na listu
		return WebConstant.PAGE_PROIZVODJACI;
	}

}
