package it.engineering.web.Day51Zadatak.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.storage.ProizvodjacStorage;

public class ProizvodjaciAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("proizvodjaci", ProizvodjacStorage.getInstance().getProizvodjaci());
		
		return WebConstant.PAGE_PROIZVODJACI;
	}
	
	

}
