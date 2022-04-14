package it.engineering.web.Day51Zadatak.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.storage.ProizvodjacStorage;

public class ProizvodjacSaveAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		String pib = request.getParameter("pib");
		String matBr = request.getParameter("matbr");
		String adresa = request.getParameter("adresa");
		String mesto = request.getParameter("mesto");
		
		if (request.getParameter("dugme").equalsIgnoreCase("cancel")) {
			// pritisnuto je cancel dugme pa se vracamo na listu
			
			List<Proizvodjac> proizvodjaci = ProizvodjacStorage.getInstance().getProizvodjaci();
			request.setAttribute("proizvodjaci", proizvodjaci);
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
		// Korisnik je odobrio da se ova izmena sacuva

		updateProizvodjac(Integer.parseInt(pib), Integer.parseInt(matBr), adresa, mesto);
		
		request.setAttribute("proizvodjaci", ProizvodjacStorage.getInstance().getProizvodjaci());
		// pa se vracamo na listu gradova
		return WebConstant.PAGE_PROIZVODJACI;
	}
	
	private void updateProizvodjac(int pib, int matBr, String adresa, String mesto) {

		List<Proizvodjac> proizvodjaci = ProizvodjacStorage.getInstance().getProizvodjaci();
		
		for (Proizvodjac p : proizvodjaci) {
			if (p.getPib() == pib) {
				p.setMaticniBroj(matBr);
				p.setAdresa(adresa);
				p.setMesto(mesto);
				// automatski su izmenjena polja clana liste
				break;
			}
		}
	}

}
