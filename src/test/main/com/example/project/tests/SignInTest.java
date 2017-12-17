package com.example.project.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.example.project.servlets.Signin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
@WebAppConfiguration
public class SignInTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private Signin signinmock;
	
	@Test
	public void signinTest() throws Exception {
		mockMvc.perform(get("http://localhost:8080/signin"))
			.andExpect(status().isOk())
			.andExpect(view().name("inscription"));
	}

}
