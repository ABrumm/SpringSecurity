package com.brumma.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 
 * <strong><u>Project:</u> demo</strong><br />
 * <strong><u>Class:</u> com.brumma.security.AuthenticationDemoSuccessHandler</strong><br />
 *
 * <hr noshade /> <strong><u>Description:</u></strong><br />
 * AuthenticationSuccessHandler for project demo, to redirect after login <br />
 * <hr noshade />
 *
 * @author Artur Brumm
 * @version 1.0
 */
public class AuthenticationDemoSuccessHandler implements AuthenticationSuccessHandler
{

    private RedirectStrategy m_redirectStrategy = new DefaultRedirectStrategy();

    @Override
	public void onAuthenticationSuccess(HttpServletRequest p_request, HttpServletResponse p_response,
			Authentication p_authentication) throws IOException, ServletException {
		handle(p_request, p_response, p_authentication);
		clearAuthenticationSuccess(p_request);
	}

    /**
     * 
     * clearAuthenticationSuccess<br />
     * TODO: Add methoddescription.
     * @param HttpServletRequest p_request
     */
    protected void clearAuthenticationSuccess( HttpServletRequest p_request )
    {
        HttpSession l_session = p_request.getSession(false);
        
        if(l_session == null) {
            return;
        }
        l_session.removeAttribute( WebAttributes.AUTHENTICATION_EXCEPTION );
        
    }

    /**
     * 
     * handle<br />
     * Redirecting implementation
     * 
     * @param HttpServletRequest
     *            p_request
     * @param HttpServletResponse
     *            p_response
     * @param Authentication
     *            p_authentication
     * @throws IOException
     */
    private void handle( HttpServletRequest p_request, HttpServletResponse p_response, Authentication p_authentication ) throws IOException
    {
        String targetUrl = determineTargetUrl( p_authentication );

        if ( p_response.isCommitted() )
        {
            return;
        }

        m_redirectStrategy.sendRedirect( p_request, p_response, targetUrl );
    }

    /**
     * 
     * determineTargetUrl<br />
     * Setting redirecting page as a String TODO: Outsource the redirectURL to a propertiesFile (maybe persistance Layer)
     * 
     * @return String
     */
    protected String determineTargetUrl( Authentication p_authentication )
    {
        return "/index.xhtml";
    }

    /**
     * 
     * getRedirectStrategy<br />
     * Getter for RedirectStrategy
     * 
     * @return RedirectStrategy m_redirectStrategy
     */
    public RedirectStrategy getRedirectStrategy()
    {
        return m_redirectStrategy;
    }

    /**
     * 
     * setRedirectStrategy<br />
     * Setter for RedirectStrategy
     * 
     * @param RedirectStrategy
     *            m_redirectStrategy
     */
    public void setRedirectStrategy( RedirectStrategy m_redirectStrategy )
    {
        this.m_redirectStrategy = m_redirectStrategy;
    }

}
