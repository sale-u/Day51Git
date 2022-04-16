package it.engineering.web.Day51Zadatak.service;

import java.util.List;

import it.engineering.web.Day51Zadatak.domain.City;

public interface CityService {
	
	List<City> getCities();
	
	City findByZipCode(int zipCode);

}
