package com.example.project.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
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
	Errors errors;
	
	@Mock
	private BlogService bs;
	
	@Mock
	BindingResult br;

	@Before 
	public void setUp() throws Exception {
		List<Theme> theme = new ArrayList<Theme>();
		Theme t = new Theme();
		t.setTitre("titre");
		t.setId(1);
		theme.add(t);
		Mockito.mock(Errors.class);
		Mockito.mock(UserConnexionValidator.class);
		MockitoAnnotations.initMocks(this);
		Mockito.when(bs.getThemes()).thenReturn(theme);
	}
	
	//@Test
	public void signinTest() throws Exception {
		assertNotNull(signincontroller.signin());
		
		ModelAndView m = signincontroller.signin();
		assertEquals("connexion",m.getViewName());
		
	}
	
	//@Test
	public void afficherAccueilTest() throws Exception {
		assertNotNull(signincontroller.afficherAccueil());
		
		ModelAndView m = signincontroller.afficherAccueil();
		assertEquals("themes",m.getViewName());
	}
	
	@Test
	public void signInProceedTest() {
		User u = new User();
		u.setEmail("marina@mail.fr");
		u.setPassword("121212");
		assertNotNull(signincontroller.signInProceed(u,br));
		ModelAndView m = signincontroller.signInProceed(u,br);
		assertEquals("redirect:themes",m.getViewName());
	}

}
