package com.brumma.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationDemoProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication p_authentication) throws AuthenticationException {
		String l_username = p_authentication.getPrincipal().toString();
		String p_password = p_authentication.getCredentials().toString();
		return null;
	}

	@Override
	public boolean supports(Class<?> p_authentication) {
		return p_authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
