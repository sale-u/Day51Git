package it.engineering.web.Day51Zadatak.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.engineering.web.Day51Zadatak.action.AbstractAction;
import it.engineering.web.Day51Zadatak.constant.WebConstant;

public class LoginGetAction extends AbstractAction {

	@Override
	public String executeRequest(HttpServletRequest request, HttpServletResponse response) {
		return WebConstant.PAGE_LOGIN;
	}

	
}
