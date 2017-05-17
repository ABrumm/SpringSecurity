package com.brumma.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.brumma.dao.UserDaoI;
import com.brumma.model.User;

public class DemoAuthenticationDetails extends WebAuthenticationDetails
{

    private static final long serialVersionUID = -2615873392921025379L;
    
    private int m_userIdentity;
    
    private User loggedUser;
    
    private String m_userName;
    
    private String m_userPW;
    
    public DemoAuthenticationDetails( HttpServletRequest request )
    {
        super( request );
        setUserName( request.getParameter( "username" ) );
        setUserPW( request.getParameter( "password" ) );
    }

    public String getUserName()
    {
        return m_userName;
    }

    public void setUserName( String m_userName )
    {
        this.m_userName = m_userName;
    }

    public String getUserPW()
    {
        return m_userPW;
    }

    public void setUserPW( String m_userPW )
    {
        this.m_userPW = m_userPW;
    }

    public int getUserIdentity()
    {
        return m_userIdentity;
    }

    public void setUserIdentity( int m_userIdentity )
    {
        this.m_userIdentity = m_userIdentity;
    }

    public User getLoggedUser()
    {
        return loggedUser;
    }

    public void setLoggedUser( User loggedUser )
    {
        this.loggedUser = loggedUser;
    }

}
