package com.example.projet.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
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
	BindingResult br;
	
	String mail;
	String password;
	
	@Before
	public void setUp() throws Exception {
		mail = "";
		password = "";
		uvc = new UserConnexionValidator();
		MockitoAnnotations.initMocks(this);
		Mockito.when(u.getEmail()).thenReturn(mail);
		Mockito.when(u.getPassword()).thenReturn(password);
	}

	@Test
	public void validateTest() {
		//demander au prof
		uvc.validate(u, br);
		System.out.println(br.getFieldErrorCount());
	}
	
	//@Test
	public void validateTest_IfNull() {
		mail = "mail";
		password ="pass";
		Mockito.when(u.getEmail()).thenReturn(mail);
		Mockito.when(u.getPassword()).thenReturn(password);
		Mockito.when(bs.findUserByEmail(u.getEmail())).thenReturn(u);
		uvc.validate(u, br);
		Mockito.verify(br,Mockito.times(2)).rejectValue("", "", "");;
		System.out.println();
	}

}
