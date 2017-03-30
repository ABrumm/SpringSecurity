package com.brumma.security;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;

public class LoginManager
{

    public String doLogin() throws ServletException, IOException
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ( (ServletRequest) context.getRequest() ).getRequestDispatcher( "/j_spring_security_check" );
        dispatcher.forward( (ServletRequest) context.getRequest(), (ServletResponse) context.getResponse() );
        return null;
    }
}
