package it.engineering.web.Day51Zadatak.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.service.ProizvodjacService;
import it.engineering.web.Day51Zadatak.service.impl.ProizvodjacServiceImpl;

public class ProizvodjaciAction extends AbstractAction {
	
	private ProizvodjacService proizvodjacService;
	
	public ProizvodjaciAction() {
		proizvodjacService = new ProizvodjacServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("proizvodjaci", proizvodjacService.getProizvodjaci());
		
		return WebConstant.PAGE_PROIZVODJACI;
	}
	
	

}
