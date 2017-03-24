package com.brumma.security;

import org.hibernate.query.Query;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.brumma.util.HibernateUtil;

public class AuthenticationDemoProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication p_authentication) throws AuthenticationException {
		String l_username = p_authentication.getPrincipal().toString();
		String l_password = p_authentication.getCredentials().toString();
		HibernateUtil.getSession().beginTransaction();
	      Query<?> sqlQuery = HibernateUtil.getSession().createQuery("FROM User WHERE userName  = :param1 AND userPassword = :param2");
	      sqlQuery.setParameter("param1", l_username);
	      sqlQuery.setParameter("param2", l_password);
	      sqlQuery.getResultList();
	      HibernateUtil.getSession().getTransaction().commit();
		return null;
	}

	@Override
	public boolean supports(Class<?> p_authentication) {
		return p_authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
