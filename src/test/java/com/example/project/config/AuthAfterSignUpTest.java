package com.example.project.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class AuthAfterSignUpTest {
	
	@Mock
	AuthAfterSignUp auth;
	
	@Mock
	Authentication authi;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.when(authi.getDetails()).thenReturn(null);
	}

	@Test
	public void authenticateTest() {
		auth.authenticate(authi);
	}

}
