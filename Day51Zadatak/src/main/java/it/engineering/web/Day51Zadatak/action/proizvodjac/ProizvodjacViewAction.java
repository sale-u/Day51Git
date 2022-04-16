package it.engineering.web.Day51Zadatak.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.Mesto;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.storage.MestoStorage;
import it.engineering.web.Day51Zadatak.storage.ProizvodjacStorage;


public class ProizvodjacViewAction extends AbstractAction{
	
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		Proizvodjac p = getProizvodjac(Integer.parseInt(request.getParameter("pib")));
		
		if (p != null) {
			request.setAttribute("proizvodjac", p);
			
			List<Mesto> mesta = MestoStorage.getInstance().getMesta();
			request.setAttribute("mesta", mesta);
			
			return WebConstant.PAGE_PROIZVODJAC_VIEW;
		}
		else {
			request.setAttribute("proizvodjaci", ProizvodjacStorage.getInstance().getProizvodjaci());
			return WebConstant.PAGE_PROIZVODJACI;
		}
	}
	
	
	
	public Proizvodjac getProizvodjac(int pib) {
		
		List<Proizvodjac> proizvodjaci = ProizvodjacStorage.getInstance().getProizvodjaci();
		
		for (Proizvodjac p : proizvodjaci) {
			if (p.getPib() == pib) return p;
		}
		return null;
	}

}
