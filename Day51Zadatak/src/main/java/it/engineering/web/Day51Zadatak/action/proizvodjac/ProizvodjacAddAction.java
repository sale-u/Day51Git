package it.engineering.web.Day51Zadatak.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.City;
import it.engineering.web.Day51Zadatak.service.CityService;
import it.engineering.web.Day51Zadatak.service.ProizvodjacService;
import it.engineering.web.Day51Zadatak.service.impl.CityServiceImpl;
import it.engineering.web.Day51Zadatak.service.impl.ProizvodjacServiceImpl;

public class ProizvodjacAddAction extends AbstractAction {
	
//	private ProizvodjacService ps;
	private CityService cs;
	
	public ProizvodjacAddAction() {
//		ps = new ProizvodjacServiceImpl();
		cs = new CityServiceImpl();
	}

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		
		List<City> cities = cs.getCities();
		request.setAttribute("cities", cities);
		
		return WebConstant.PAGE_PROIZVODJAC_ADD;
	}

	
	
}
