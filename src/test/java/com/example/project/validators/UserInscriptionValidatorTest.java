package com.example.project.validators;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.validators.UserInscriptionValidator;

public class UserInscriptionValidatorTest {
	
	@Mock
	BlogService bs;
	
	@InjectMocks
	UserInscriptionValidator uic;
	
	@Mock
	BindingResult br;
	
	@Before
	public void setUp() throws Exception {
		//uic = new UserInscriptionValidator();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void validateTest_ErrorMdp_Mail() {
		User u = new User();
		u.setEmail("mail");
		u.setPassword("pass");
		u.setConfirm("passss");
		
		Mockito.when(bs.findUserByEmail("mail")).thenReturn(new User());
		
		uic.validate(u, br);
		
		Mockito.verify(br,Mockito.times(1)).rejectValue("confirm", "password.confirm", "Les mots de passe ne correspondent pas !");
		Mockito.verify(br,Mockito.times(1)).rejectValue("email", "email.exists", "L'adresse mail est déjà utilisée !");
	}

}
