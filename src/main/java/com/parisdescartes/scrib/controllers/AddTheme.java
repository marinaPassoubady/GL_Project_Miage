package com.parisdescartes.scrib.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.parisdescartes.scrib.entities.Categorie;
import com.parisdescartes.scrib.entities.Theme;
import com.parisdescartes.scrib.entities.User;
import com.parisdescartes.scrib.service.BlogService;
import com.parisdescartes.scrib.tools.Constante;

@Controller
public class AddTheme {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value="/themes")
	public ModelAndView ajouterTheme(@Valid Theme theme, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName(Constante.ACCUEIL_ERREUR);
			return model;
		}
		theme
		.setAuteur((User)session.getAttribute(Constante.USER))
		.setCategorieColor(Categorie.getCategoryColor(theme.getCategorie()));
		blogService.addTheme(theme);
		model.setViewName(Constante.ACCUEIL);
		return model;
	}

}
