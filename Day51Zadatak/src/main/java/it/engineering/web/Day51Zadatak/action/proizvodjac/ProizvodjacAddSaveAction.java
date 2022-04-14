package it.engineering.web.Day51Zadatak.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.storage.ProizvodjacStorage;


public class ProizvodjacAddSaveAction extends AbstractAction {

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

		Proizvodjac newP = addProizvodjac(Integer.parseInt(pib), Integer.parseInt(matBr), adresa, mesto);
		
		if (newP == null) {
			// vec postoji takav -> ne moze
			request.setAttribute("error_message", "Takav vec postoji - pokusajte ponovo");
			return WebConstant.PAGE_PROIZVODJAC_ADD;
		}
		
		request.setAttribute("proizvodjaci", ProizvodjacStorage.getInstance().getProizvodjaci());
		// pa se vracamo na listu
		return WebConstant.PAGE_PROIZVODJACI;
	}

	private Proizvodjac addProizvodjac(int pib, int matBr, String adresa, String mesto) {

		List<Proizvodjac> proizvodjaci = ProizvodjacStorage.getInstance().getProizvodjaci();
		
		Proizvodjac newP = new Proizvodjac(pib, matBr, adresa, mesto);
		
		// equals metoda iz Proizvodjac klase poredi samo pib polje
		if (proizvodjaci.contains(newP)) {
			// vec postoji takav -> ne moze
			return null;
			
		} else {
			ProizvodjacStorage.getInstance().add(newP);
			return newP;
			
		}	
		
	}

}
