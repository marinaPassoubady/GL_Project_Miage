package com.example.project.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.project.entities.User;

@Component
@Qualifier("afterSignup")
public class AuthAfterSignUp implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		 
		User user = (User)auth.getDetails(); 
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
	            (user.getEmail(), user.getPassword(), Collections.emptyList());
		return token;
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
