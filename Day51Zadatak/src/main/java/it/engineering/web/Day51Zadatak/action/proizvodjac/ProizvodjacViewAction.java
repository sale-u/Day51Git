package it.engineering.web.Day51Zadatak.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;
import it.engineering.web.Day51Zadatak.domain.City;
import it.engineering.web.Day51Zadatak.domain.Mesto;
import it.engineering.web.Day51Zadatak.domain.Proizvodjac;
import it.engineering.web.Day51Zadatak.service.CityService;
import it.engineering.web.Day51Zadatak.service.ProizvodjacService;
import it.engineering.web.Day51Zadatak.service.impl.CityServiceImpl;
import it.engineering.web.Day51Zadatak.service.impl.ProizvodjacServiceImpl;
import it.engineering.web.Day51Zadatak.storage.MestoStorage;
import it.engineering.web.Day51Zadatak.storage.ProizvodjacStorage;


public class ProizvodjacViewAction extends AbstractAction{
	
	private CityService cityService;
	private ProizvodjacService proizvodjacService;
	
	public ProizvodjacViewAction() {
		cityService = new CityServiceImpl();
		proizvodjacService = new ProizvodjacServiceImpl();
	}
	
	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {

		Proizvodjac p = getProizvodjac(request.getParameter("pib"));
		
		if (p != null) {
			request.setAttribute("proizvodjac", p);
			
//			List<Mesto> mesta = MestoStorage.getInstance().getMesta();
			
			List<City> cities = cityService.getCities();
//			System.out.println(cities);
			
			request.setAttribute("cities", cities);
			
			return WebConstant.PAGE_PROIZVODJAC_VIEW;
		}
		else {
			request.setAttribute("proizvodjaci", cityService.getCities());
			return WebConstant.PAGE_PROIZVODJACI;
		}
	}
	
	
	
	public Proizvodjac getProizvodjac(String pib) {
		
//		List<Proizvodjac> proizvodjaci = ProizvodjacStorage.getInstance().getProizvodjaci();
		
		List<Proizvodjac> proizvodjaci = proizvodjacService.getProizvodjaci();
		
		for (Proizvodjac p : proizvodjaci) {
			if (p.getPib().equals(pib)) return p;
		}
		return null;
	}

}
