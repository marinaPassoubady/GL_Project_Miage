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

import com.parisdescartes.scrib.controllers.AddArticle;
import com.parisdescartes.scrib.entities.Article;
import com.parisdescartes.scrib.entities.Theme;
import com.parisdescartes.scrib.service.BlogService;

public class AddArticleTest {
	
	@InjectMocks
	private AddArticle addArticleController;
	
	@Mock
	private BlogService bs;
	
	@Mock
	private BindingResult br;
	
	@Mock
	private Article article;
	
	@Mock
	private HttpSession session;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void ajouterArticleTest_HasErrors() {
		Mockito.when(br.hasErrors()).thenReturn(true);
		assertEquals("theme",addArticleController.ajouterArticle(1, article, br).getViewName());
	}
	
	@Test
	public void ajouterArticleTest_NoError() {
		Mockito.when(br.hasErrors()).thenReturn(false);
		Mockito.when(article.getTheme()).thenReturn(new Theme());
		assertEquals("redirect:theme?id=2",addArticleController.ajouterArticle(2, article, br).getViewName());
	}

}
