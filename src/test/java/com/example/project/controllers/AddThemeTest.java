package com.example.project.controllers;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import com.parisdescartes.scrib.controllers.AddTheme;
import com.parisdescartes.scrib.entities.Theme;
import com.parisdescartes.scrib.entities.User;
import com.parisdescartes.scrib.service.BlogService;

public class AddThemeTest {
	
	@InjectMocks
	private AddTheme addThemeController;
	
	@Mock
	private BlogService bs;
	
	@Mock
	BindingResult br;
	
	@Mock
	private HttpSession session;
	
	@Before 
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(session.getAttribute("user")).thenReturn(new User());
	}
	
	@Test
	public void ajouterThemeTest_HasErrors() {
		Mockito.when(br.hasErrors()).thenReturn(true);
		assertEquals(null,addThemeController.ajouterTheme(new Theme(),br).getViewName());
	}
	
	@Test()
	public void ajouterThemeTest_NoError() {
		Mockito.when(br.hasErrors()).thenReturn(false);
		assertEquals("redirect:themes",addThemeController.ajouterTheme(new Theme(),br).getViewName());
	}

}
