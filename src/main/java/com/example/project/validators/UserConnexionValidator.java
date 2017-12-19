package com.example.project.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.project.entities.User;
import com.example.project.service.impl.BlogServiceImpl;


@Component
public class UserConnexionValidator implements Validator{

	
	@Autowired 
	BlogServiceImpl blogService;
	
	@Override
	public boolean supports(Class<?> obj) {
		return User.class.equals(obj);
	}

	@Override
	public void validate(Object obj, Errors err) {
		User user = (User) obj;

		
		if(user.getEmail().equals("") || user.getPassword().equals("")) {
		 if(user.getEmail().equals("")) err.rejectValue("email", "email.inexists","Le mail doit être renseigné.");
		 if(user.getPassword().equals("")) err.rejectValue("password", "password.inexists","Le mot de passe est obligatoire.");
		}
		else {
			User tmp = blogService.findUserByEmail(user.getEmail());
			if(tmp == null ) {
				err.rejectValue("email", "email.inexists","Ce mail n'existe pas.");
			}
			else {
				if(!tmp.getPassword().equals(user.getPassword())) {
					err.rejectValue("password", "password.incorrect","Le mot de passe n'est pas valide.");
				}
			}
	
		}
	
	}

}
