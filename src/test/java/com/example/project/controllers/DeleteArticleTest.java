package com.example.project.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.parisdescartes.scrib.controllers.DeleteArticle;
import com.parisdescartes.scrib.service.BlogService;

public class DeleteArticleTest {
	
	@InjectMocks
	private DeleteArticle deleteArticleController;
	
	@Mock
	private BlogService bs;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void supprimerArticleTest() {
		assertNotNull(deleteArticleController.supprimerArticle(1, 1));
		
		assertEquals("redirect:theme?id=1",deleteArticleController.supprimerArticle(1, 1).getViewName());
	}

}
