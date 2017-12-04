package com.example.project.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;
import com.example.project.service.BlogServiceInterface;

@Component
public class UserSignInValidator implements Validator {
	
	@Autowired 
	BlogServiceInterface blogService;
	
	@Override
	public boolean supports(Class<?> c) {
		return User.class.equals(c);
	}

	@Override
	public void validate(Object obj, Errors err) {
		User user = (User) obj;
		if(!user.getPassword().equals(user.getConfirm())) {
			err.rejectValue("confirm", "password.confirm", "Les mots de passe ne correspondent pas !");
		}
			
		if(blogService.findUserByEmail(user.getEmail())!= null) {
			err.rejectValue("email", "email.exists", "L'adresse mail est déjà utilisée !");
		}
	}

}
