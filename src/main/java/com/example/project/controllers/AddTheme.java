package com.example.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Theme;
import com.example.project.service.BlogService;
import com.example.project.tools.Constantes;

@Controller
public class AddTheme {
	
	@Autowired
	BlogService blogService;
	
	@PostMapping(value="/themes")
	public ModelAndView ajouterTheme(@Valid Theme theme, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.addObject(Constantes.hasError, true);
			return model;
		}
		blogService.addTheme(theme);
		model.setViewName(Constantes.redirect_themes);
		return model;
	}

}
