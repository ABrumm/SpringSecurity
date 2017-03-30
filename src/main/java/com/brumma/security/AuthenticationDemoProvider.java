package com.brumma.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.brumma.dao.UserDaoI;

public class AuthenticationDemoProvider implements AuthenticationProvider
{

    private UserDaoI m_userService;

    @Override
    public Authentication authenticate( Authentication p_authentication ) throws AuthenticationException
    {
        String l_username = p_authentication.getPrincipal().toString();
        String l_password = p_authentication.getCredentials().toString();
       
        ArrayList<com.brumma.model.User> l_pList = m_userService.getPrincipal( l_username, l_password );
        if ( l_pList.size() > 0 )
        {
            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add( new SimpleGrantedAuthority( "ROLE_USER" ) );
            final UserDetails l_principal = new User(l_username, l_password, grantedAuths);
            return new UsernamePasswordAuthenticationToken( l_principal, l_password, grantedAuths );
        } else {            
            return null;
        }
    }

    @Override
    public boolean supports( Class<?> p_authentication )
    {
        return p_authentication.equals( UsernamePasswordAuthenticationToken.class );
    }

    public void setUserService( UserDaoI p_userService )
    {
        this.m_userService = p_userService;
    }

    public UserDaoI getUserService()
    {
        return m_userService;
    }

}
