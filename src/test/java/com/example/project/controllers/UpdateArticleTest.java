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

import com.parisdescartes.scrib.controllers.UpdateArticle;
import com.parisdescartes.scrib.entities.User;
import com.parisdescartes.scrib.exceptions.ArticleInexistantException;
import com.parisdescartes.scrib.exceptions.DejaVoteException;
import com.parisdescartes.scrib.service.BlogService;

public class UpdateArticleTest {
	
	@InjectMocks
	private UpdateArticle updateArticleController;
	
	@Mock
	private BlogService bs;
	
	@Mock
	BindingResult br;
	
	@Mock
	private HttpSession session;
	
	@Mock
	User u;
	
	@Before 
	public void setUp() throws ArticleInexistantException, DejaVoteException {
		MockitoAnnotations.initMocks(this);
		
		//Mockito.when(bs.evaluerArticle(1, 1, 1)).thenReturn(1);
		Mockito.when(session.getAttribute("user")).thenReturn(u);
		Mockito.when(u.getId()).thenReturn(1);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void evaluerArticleTest_ThrowArticleInexistantException() throws ArticleInexistantException, DejaVoteException {
		Mockito.when(bs.evaluerArticle(1, 1, 1)).thenThrow(ArticleInexistantException.class);
		assertEquals("redirect:theme?id=1",updateArticleController.evaluerArticle(1, 1, 1).getViewName());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void evaluerArticleTest_ThrowDejaVoteException() throws ArticleInexistantException, DejaVoteException {
		Mockito.when(bs.evaluerArticle(1, 1, 1)).thenThrow(DejaVoteException.class);
		assertEquals("redirect:theme?id=1#1",updateArticleController.evaluerArticle(1, 1, 1).getViewName());
	}

}
