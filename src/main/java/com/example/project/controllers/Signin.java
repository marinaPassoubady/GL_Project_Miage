package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.tools.Constantes;
import com.example.project.validators.UserConnexionValidator;
import com.example.project.validators.UserInscriptionValidator;

@Controller
@SessionAttributes("theme")
public class Signin {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	private UserConnexionValidator userConnexionValidator;
	
	@GetMapping("/")
	public ModelAndView signin() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		model.setViewName(Constantes.connexion);
		return model;
	}
	
	@PostMapping("/")
	public ModelAndView signInProceed(@ModelAttribute User user, BindingResult result/*, HttpSession session */) {
		ModelAndView model = new ModelAndView();
		userConnexionValidator.validate(user, result);
		if(result.hasErrors()) {
			model.setViewName(Constantes.connexion);
			return model;
		}
		model.setViewName(Constantes.redirect_themes);
		return model;
	}
	
	@GetMapping(value="/themes")
	public ModelAndView afficherAccueil() {
		ModelAndView model = new ModelAndView();
		model.addObject(Constantes.themes, blogService.getThemes());
		model.addObject(Constantes.theme, new Theme());
		return model;
	}

}
