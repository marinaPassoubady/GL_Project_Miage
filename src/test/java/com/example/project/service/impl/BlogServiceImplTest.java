package com.example.project.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.exceptions.ThemeInexistantException;
import com.example.project.repositories.ThemeRepository;
import com.example.project.repositories.UserRepository;


@RunWith(SpringRunner.class)
public class BlogServiceImplTest {

	@Mock
	private ThemeRepository themeRepository;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@InjectMocks
	BlogServiceImpl bsi;
	
	@Mock
	private User alex;
	
	User user;
	Theme theme;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		user = new User();
		theme = new Theme();
		ArrayList<Theme> themes = new ArrayList<Theme>();
		
		themes.add(new Theme());
		themes.add(new Theme());

		Mockito.when(themeRepository.findByAuteur(alex))
		.thenReturn(new ArrayList<Theme>());
		
		Mockito.when(alex.getPassword()).thenReturn("password");
		
		Mockito.when(passwordEncoder.encode(alex.getPassword()))
		.thenReturn("password_encoded");
		
		Mockito.when(userRepository.save(alex)).thenReturn(user);
		Mockito.when(userRepository.findByEmail("mail@mail.fr")).thenReturn(alex);
		Mockito.when(themeRepository.save(theme)).thenReturn(theme);
		Mockito.when(userRepository.findOne(1)).thenReturn(user);
		
		Mockito.when(themeRepository.findAll()).thenReturn(themes);

	}
	
	@Test
	public void addUserTest() {
		assertEquals(user,bsi.addUser(alex));
	}
	
	@Test
	public void findUserByEmailTest() {
		assertEquals(alex,bsi.findUserByEmail("mail@mail.fr"));
	}
	
	@Test 
	public void addThemeTest() {
		bsi.addTheme(theme);
	}
	
	@Test
	public void findUserByIDTest() {
		assertEquals(user,bsi.findUserByID(1));
	}
	
	@Test
	public void getThemesTest() {
		assertEquals(2,bsi.getThemes().size());
	}
	
	
	@Test
	public void findThemesByAuteurTest() {
		assertEquals(new ArrayList<Theme>(),bsi.findThemesByAuteur(alex));
	}
	
	@Test(expected = ThemeInexistantException.class)
	public void findThemeTest_ThrowException() throws ThemeInexistantException {
		Mockito.when(themeRepository.findOne(1)).thenReturn(null);
		assertEquals(null,bsi.findTheme(1));
	}
	
	@Test
	public void findThemeTest() throws ThemeInexistantException {
		Mockito.when(themeRepository.findOne(1)).thenReturn(theme);
		assertEquals(theme,bsi.findTheme(1));
	}
	

}
