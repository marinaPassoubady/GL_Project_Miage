package com.example.project.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.controllers.Signin;
import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.validators.UserConnexionValidator;

@RunWith(SpringRunner.class)
public class SignInTest {

	@InjectMocks
	private Signin signincontroller;
	
	@Mock
	private UserConnexionValidator ucv;
	
	@Mock
	private Errors errors;
	
	@Mock
	private BlogService bs;
	
	@Mock
	private BindingResult br;
	
	@Mock
	private HttpSession session;

	@Before 
	public void setUp() throws Exception {
		List<Theme> theme = new ArrayList<Theme>();
		Theme t = new Theme();
		t.setTitre("titre");
		t.setId(1);
		theme.add(t);
		MockitoAnnotations.initMocks(this);
		Mockito.when(bs.getThemes()).thenReturn(theme);
	}
	
	@Test
	public void signinTest() throws Exception {
		assertNotNull(signincontroller.signin());
		
		ModelAndView m = signincontroller.signin();
		assertEquals("connexion",m.getViewName());
		
	}
	
	@Test
	public void afficherAccueilTest() throws Exception {
		session.setAttribute("user", new User());
		assertNotNull(signincontroller.afficherAccueil(""));
		
		assertEquals("themes",signincontroller.afficherAccueil("").getViewName());
	}

}
