package com.example.project.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.example.project.controllers.Signin;



//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SignInTest {
	
	/*
	@Autowired
	private WebApplicationContext webappContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webappContext).build();
	}*/
	
	@InjectMocks
	private Signin signincontroller;

	@Before 
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void signinTest() throws Exception {
		assertNotNull(signincontroller.signin());
	}

}
