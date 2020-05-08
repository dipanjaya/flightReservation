package com.fr.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Override
	public boolean login(String username, String password) {

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());

		manager.authenticate(token);

		boolean authenticated = token.isAuthenticated();

		if (authenticated) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return authenticated;
	}

}
