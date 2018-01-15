package com.example.project.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.tools.Constante;

@Controller
@PropertySource("constante.properties")
public class AddTheme {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	@Value("${verif.hasError}")
    private String hasError;
	
	@Value("${page.accueil}")
    private String redirectAccueil;
	
	@PostMapping(value="/themes")
	public ModelAndView ajouterTheme(@Valid Theme theme, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName(Constante.ACCUEIL_ERREUR);
			return model;
		}
		theme.setAuteur((User)session.getAttribute(Constante.USER));
		blogService.addTheme(theme);
		model.setViewName(Constante.ACCUEIL);
		return model;
	}

}
