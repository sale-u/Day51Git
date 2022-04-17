package it.engineering.web.Day51Zadatak.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.service.ProizvodjacService;
import it.engineering.web.Day51Zadatak.service.impl.ProizvodjacServiceImpl;


public class ProizvodjacConfirmDeleteAction extends AbstractAction {
	
	// potvrda da li zaista brisemo proizvodjaca
	// zove ga dugme "Obrisi" sa proizvodjaci.jsp
	// salje na proizvodjac-confirm-del.jsp
	
	private ProizvodjacService ps;
	
	public ProizvodjacConfirmDeleteAction() {
		ps = new ProizvodjacServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		String pib = request.getParameter("pib");
		Proizvodjac zaConfBrisanja = ps.findByPib(pib);
		
		if (zaConfBrisanja != null) {
			// idemo na stranicu potvrde brisanja
			request.setAttribute("proizvodjac", zaConfBrisanja);
			return WebConstant.PAGE_PROIZVODJAC_CONFIRM_DELETE;
		}
		
		request.setAttribute("proizvodjaci", ps.getProizvodjaci());
		// pa se vracamo na listu
		return WebConstant.PAGE_PROIZVODJACI;
	}

}
