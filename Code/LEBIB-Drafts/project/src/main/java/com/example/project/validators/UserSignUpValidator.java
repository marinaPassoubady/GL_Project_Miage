package com.example.project.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;


@Component
public class UserSignUpValidator implements Validator{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean supports(Class<?> obj) {
		return User.class.equals(obj);
	}

	@Override
	public void validate(Object obj, Errors err) {
		User user = (User) obj;

		
		if(user.getEmail().equals("") || user.getPassword().equals("")) {
		 if(user.getEmail().equals("")) err.rejectValue("email", "email.inexists","Veuillez renseigner l'email ! ");
		 if(user.getPassword().equals("")) err.rejectValue("password", "password.inexists","Veuillez renseigner un mot de passe ! ");
		}
		else {
			User tmp = userRepository.findByEmail(user.getEmail());
			if(tmp == null ) {
				err.rejectValue("email", "email.inexists","L'email n'existe pas !");
			}
			else {
				if(!tmp.getPassword().equals(user.getPassword())) {
					err.rejectValue("password", "password.incorrect","Mot de passe incorrect !");
				}
			}
	
		}
	
	}

}
