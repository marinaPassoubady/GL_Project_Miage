package com.example.projet.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.validators.UserConnexionValidator;

public class UserConnexionValidatorTest {
	
	@Mock
	BlogService bs;

	UserConnexionValidator uvc;
	
	@Mock
	User u;
	
	@Mock
	Errors err;
	
	@Before
	public void setUp() throws Exception {
		uvc = new UserConnexionValidator();
		MockitoAnnotations.initMocks(this);
		Mockito.when(u.getEmail()).thenReturn("");
		Mockito.when(u.getPassword()).thenReturn("");
	}

	@Test
	public void validateTest() {
		uvc.validate(u, err);
		err.rejectValue("field","code","defaultmessage");
		System.out.println(err.getFieldErrors("field"));
	}

}
