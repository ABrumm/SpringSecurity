package com.brumma.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;

public class DemoAccessDeniedHandler implements AccessDeniedHandler
{

    private RedirectStrategy m_redirectStrategy = new DefaultRedirectStrategy();
    
    @Override
    public void handle( HttpServletRequest p_request, HttpServletResponse p_response, AccessDeniedException p_accessDeniedException ) throws IOException, ServletException
    {
       String targetUrl = "/index.xhtml";
       Authentication l_auth = SecurityContextHolder.getContext().getAuthentication();
       
       m_redirectStrategy.sendRedirect( p_request, p_response, targetUrl );
    }

    public RedirectStrategy getRedirectStrategy()
    {
        return m_redirectStrategy;
    }

    public void setRedirectStrategy( RedirectStrategy m_redirectStrategy )
    {
        this.m_redirectStrategy = m_redirectStrategy;
    }

}
