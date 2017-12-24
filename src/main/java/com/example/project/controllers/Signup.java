package com.example.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.validators.UserInscriptionValidator;

@Controller
@PropertySource("constante.properties")
public class Signup {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	private UserInscriptionValidator userInscriptionValidator;
	
	@Value("${page.inscription}")
    private String pageInscription;
	
	@Value("${page.accueil}")
    private String redirectAccueil;
	
	@GetMapping("/signin")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName(pageInscription);
		return model;
	}
	
	@PostMapping(value="/signin")
	public String signUpProceed(@Valid User user, BindingResult result) {
		userInscriptionValidator.validate(user, result);
		if(result.hasErrors()) return pageInscription;
		blogService.addUser(user);
		return redirectAccueil;
	}

}
