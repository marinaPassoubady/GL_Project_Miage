package com.example.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Theme;
import com.example.project.service.BlogService;

@Controller
@PropertySource("constante.properties")
public class AddTheme {
	
	@Autowired
	BlogService blogService;
	
	@Value("${verif.hasError}")
    private String hasError;
	
	@Value("${page.accueil}")
    private String redirectAccueil;
	
	@PostMapping(value="/themes")
	public ModelAndView ajouterTheme(@Valid Theme theme, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.addObject(hasError, true);
			return model;
		}
		blogService.addTheme(theme);
		model.setViewName(redirectAccueil);
		return model;
	}

}
