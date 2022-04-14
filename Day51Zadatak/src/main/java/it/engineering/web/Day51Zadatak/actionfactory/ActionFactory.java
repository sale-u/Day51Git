package it.engineering.web.Day51Zadatak.actionfactory;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.action.login.LoginGetAction;
import it.engineering.web.Day51Zadatak.action.login.LoginPostAction;
import it.engineering.web.Day51Zadatak.action.logout.LogoutAction;
import it.engineering.web.Day51Zadatak.action.proizvodjac.ProizvodjacAddAction;
import it.engineering.web.Day51Zadatak.action.proizvodjac.ProizvodjacAddSaveAction;
import it.engineering.web.Day51Zadatak.action.proizvodjac.ProizvodjacSaveAction;
import it.engineering.web.Day51Zadatak.action.proizvodjac.ProizvodjacViewAction;
import it.engineering.web.Day51Zadatak.action.proizvodjac.ProizvodjaciAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;

public class ActionFactory {
	public static AbstractAction createAction(String method, String path) {
		
		AbstractAction action = null;

		switch (path) {
	case WebConstant.PATH_LOGIN:
		if (method.equalsIgnoreCase("GET")) action = new LoginGetAction();
		if (method.equalsIgnoreCase("POST")) action = new LoginPostAction();
		break;
		
	case WebConstant.PATH_LOGOUT:
		action = new LogoutAction();
		break;
	case WebConstant.PATH_PROIZVODJACI:
		action = new ProizvodjaciAction();
		break;
	case WebConstant.PATH_PROIZVODJAC_VIEW:
		action = new ProizvodjacViewAction();
		break;
	case WebConstant.PATH_PROIZVODJAC_SAVE:
		action = new ProizvodjacSaveAction();
		break;
	case WebConstant.PATH_PROIZVODJAC_ADD:
		action = new ProizvodjacAddAction();
		break;
	case WebConstant.PATH_PROIZVODJAC_ADD_SAVE:
		action = new ProizvodjacAddSaveAction();
		break;		
		
		default:
			break;
		}

		return action;

	}

}
