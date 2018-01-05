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

import com.example.project.entities.User;
import com.example.project.exceptions.ArticleInexistantException;
import com.example.project.exceptions.DejaVoteException;
import com.example.project.service.BlogService;

public class UpdateArticleTest {
	
	@InjectMocks
	private UpdateArticle updateArticleController;
	
	@Mock
	private BlogService bs;
	
	@Mock
	BindingResult br;
	
	@Mock
	private HttpSession session;
	
	@Before 
	public void setUp() throws ArticleInexistantException, DejaVoteException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(bs.evaluerArticle(1, 1, 1)).thenReturn(1);
		//Mockito.when(bs.evaluerArticle(1, 1, 1)).thenThrow(ArticleInexistantException.class);
		Mockito.when(session.getAttribute("user")).thenReturn(new User());
	}

	@Test
	public void evaluerArticleTest() throws ArticleInexistantException, DejaVoteException {
		assertEquals("redirect:theme?id=1#1",updateArticleController.evaluerArticle(1, 1, 1).getViewName());
	}

}
