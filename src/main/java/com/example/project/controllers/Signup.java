package com.example.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.tools.Constantes;
import com.example.project.validators.UserInscriptionValidator;

@Controller
public class Signup {
	@Autowired
	BlogService blogService;
	
	@Autowired
	private UserInscriptionValidator userInscriptionValidator;
	
	@GetMapping("/signin")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName(Constantes.inscription);
		return model;
	}
	
	@PostMapping(value="/signin")
	public String signUpProceed(@Valid User user, BindingResult result) {
		userInscriptionValidator.validate(user, result);
		if(result.hasErrors()) return Constantes.inscription;
		blogService.addUser(user);
		return Constantes.redirect_themes;
	}

}
