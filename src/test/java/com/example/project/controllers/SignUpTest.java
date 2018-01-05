package com.example.project.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.validators.UserInscriptionValidator;

@RunWith(SpringRunner.class)
public class SignUpTest {
	
	@InjectMocks
	private Signup signupcontroller;
	
	@Mock
	private BlogService bs;
	
	@Mock
	BindingResult br;
	
	@Mock
	private UserInscriptionValidator userInscriptionValidator;
	
	@Mock
	private User u;
	
	@Before 
	public void setUp() throws Exception {
		u = new User();
		MockitoAnnotations.initMocks(this);
		Mockito.when(br.hasErrors()).thenReturn(true);
		Mockito.when(u.getEmail()).thenReturn("marina@mail.fr");
		Mockito.when(u.getConfirm()).thenReturn("moi");
		Mockito.when(u.getPassword()).thenReturn("moi");
		
	}
	
	@Test
	public void signupTest() {
		signupcontroller.signup();
		assertNotNull(signupcontroller.signup());
		
		assertEquals("inscription",signupcontroller.signup().getViewName());
	}
	
	@Test
	public void signUpProceedTest_ErrorInfosUser() {
		assertEquals("inscription",signupcontroller.signUpProceed(u,br));
	}

}
