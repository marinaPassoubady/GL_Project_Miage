package com.example.project.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.project.entities.Theme;
import com.example.project.exceptions.ThemeInexistantException;
import com.example.project.service.BlogService;

public class ConsultThemeTest {
	
	@InjectMocks
	private ConsultTheme consultThemeController;
	
	@Mock
	private BlogService bs;
	
	@Mock
	private HttpSession session;
	
	@Before 
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void consulterThemeTest_ThemeExistant() {
		
		assertEquals("theme",consultThemeController.consulterTheme(1).getViewName());
	}
	
	@Test/*(expected = ThemeInexistantException.class)*/
	public void consulterThemeTest_ThemeNonExistant() throws ThemeInexistantException {
		Mockito.when(bs.findTheme(1)).thenThrow(new ThemeInexistantException("theme n'existe pas"));
		assertEquals("themes",consultThemeController.consulterTheme(1).getViewName());
	}

}
