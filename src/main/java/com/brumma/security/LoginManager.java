package com.brumma.security;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginManager {

	public String doLogin() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("j_spring_security_check");
		try {
			dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
		} catch (ServletException | IOException e) {
			//TODO: Logging Error with Logger
			System.out.println("Exception in doLogin() ...");
		}
		return null;
	}
}
