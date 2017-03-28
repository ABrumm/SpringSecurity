package com.brumma.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationDemoSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy m_redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest p_request, HttpServletResponse p_response,
			Authentication p_authentication) throws IOException, ServletException {
		handle(p_request, p_response, p_authentication);

	}

	private void handle(HttpServletRequest p_request, HttpServletResponse p_response, Authentication p_authentication) {
		String targetUrl = determineTargetUrl(p_authentication);

		if ( p_response.isCommitted() ) {
			return;
		}
	}

	protected String determineTargetUrl(Authentication authentication) {

		return "index.xhtml";
	}

	public RedirectStrategy getRedirectStrategy() {
		return m_redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy m_redirectStrategy) {
		this.m_redirectStrategy = m_redirectStrategy;
	}

}
