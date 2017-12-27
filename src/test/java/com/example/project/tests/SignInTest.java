package com.example.project.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.validation.Errors;

import com.example.project.controllers.Signin;
import com.example.project.entities.User;
import com.example.project.validators.UserConnexionValidator;

@TestPropertySource("constante.properties")
public class SignInTest {

	@InjectMocks
	private Signin signincontroller;
	
	@InjectMocks
	private UserConnexionValidator ucv;
	
	@Autowired
	private Errors err;

	@Before 
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void signinTest() throws Exception {
		assertNotNull(signincontroller.signin());
		
		/* Ce test renvoie null, quand on passe par le serveur "http://localhost:8080/" -> ça fonctionne */
		
		//ModelAndView m = signincontroller.signin();
		//System.out.println(m.getViewName());
		
		User user = new User();
		user.setEmail("marina.passoubady@gmail.com");
		user.setPassword("032114");
		
		ucv.validate(user,err);
	}

}
