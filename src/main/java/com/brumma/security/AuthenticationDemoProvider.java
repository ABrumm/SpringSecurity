package com.brumma.security;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.brumma.dao.UserDaoI;
import com.brumma.model.User;
import com.brumma.util.HibernateUtil;

public class AuthenticationDemoProvider implements AuthenticationProvider {
	
	private UserDaoI m_userService;
	
	@Override
	public Authentication authenticate(Authentication p_authentication) throws AuthenticationException {
		String l_username = p_authentication.getPrincipal().toString();
		String l_password = p_authentication.getCredentials().toString();
		ArrayList<User> l_pList = m_userService.getPrincipal(l_username, l_password);
		
	
		return null;
	}

	@Override
	public boolean supports(Class<?> p_authentication) {
		return p_authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public void setUserService(UserDaoI p_userService) {
		this.m_userService = p_userService;
	}

	public UserDaoI getUserService() {
		return m_userService;
	}

}