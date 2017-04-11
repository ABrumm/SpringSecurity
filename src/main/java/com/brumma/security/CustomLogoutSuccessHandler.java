package com.brumma.security;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler
{

    @Override
    public void onLogoutSuccess( HttpServletRequest p_request, HttpServletResponse p_response, Authentication p_authentication )
    throws IOException, ServletException
    {
        SecurityContextLogoutHandler l_securityContextLogoutHandler = new SecurityContextLogoutHandler();

        l_securityContextLogoutHandler.setInvalidateHttpSession( true );
        l_securityContextLogoutHandler.setClearAuthentication( true );
        l_securityContextLogoutHandler.logout( p_request, p_response, p_authentication );

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        if ( p_response.isCommitted() )
        {
            return;
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect( determineTargetUrl() );

        super.onLogoutSuccess( p_request, p_response, p_authentication );
    }

    /**
     * 
     * determineTargetUrl<br />
     * Setting redirecting page as a String TODO: Outsource the redirectURL to a propertiesFile (maybe persistance Layer)
     * 
     * @return String
     */
    protected String determineTargetUrl()
    {
        return "/demo/login.xhtml";
    }

}
