package it.engineering.web.Day51Zadatak.actionfactory;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.action.login.LoginGetAction;
import it.engineering.web.Day51Zadatak.action.login.LoginPostAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;

public class ActionFactory {
	public static AbstractAction createAction(String method, String path) {
		
		AbstractAction action = null;

		switch (path) {
	case WebConstant.PATH_LOGIN:
		if (method.equalsIgnoreCase("GET")) action = new LoginGetAction();
		if (method.equalsIgnoreCase("POST")) action = new LoginPostAction();
		break;
		
//	case WebConstant.PATH_LOGOUT:
//		action = new LogoutAction();
//		break;
//	case WebConstant.PATH_CITY:
//		action = new CitiesAction();
//		break;
//	case WebConstant.PATH_CITY_VIEW:
//		action = new CityViewAction();
//		break;

		default:
			break;
		}

		return action;

	}

}
