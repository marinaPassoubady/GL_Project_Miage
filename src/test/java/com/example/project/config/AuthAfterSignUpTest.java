package com.example.project.config;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;

import com.example.project.entities.User;

@PropertySource("dateformat.properties")
public class AuthAfterSignUpTest {
	
	@Mock
	AuthAfterSignUp auth;
	
	@Mock
	Authentication authi;
	
	@Value("${dateformat}")
	private String dateFormat;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(authi.getDetails()).thenReturn(null);
	}

	@Test
	public void authenticateTest() {
		auth.authenticate(authi);
	}
	
	@Test
	public void test() {
		User u = new User();
		u.setNom("moi");
		System.out.println(u.getNom());
	}

}
