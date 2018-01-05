package com.example.project.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.repositories.ThemeRepository;
import com.example.project.service.BlogService;

@RunWith(SpringRunner.class)
public class BlogServiceImplTest {

	@MockBean
	private ThemeRepository themeRepository;
	
	@Before
	public void setUp() {
		User alex = new User();
		alex.setId(1);

		Mockito.when(themeRepository.findByAuteur(alex))
		.thenReturn(new ArrayList<Theme>());
	}
	
	
	@Test
	public void test() {
		
	}
}