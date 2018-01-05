package com.example.project.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.exceptions.ThemeInexistantException;
import com.example.project.service.BlogService;
import com.example.project.tools.Constante;

@Controller
@PropertySource("constante.properties")
public class ConsultTheme {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	@ModelAttribute
	@GetMapping(value="theme")
	public ModelAndView consulterTheme(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView();
		try {
			Theme theme = blogService.findTheme(id);
			model.addObject(Constante.theme, theme);
			Article article = new Article();
			model.addObject(Constante.article, article);
			model.addObject(Constante.user, (User)session.getAttribute(Constante.user));
			model.setViewName(Constante.theme);
			return model;
		} catch (ThemeInexistantException e) {
			model.setViewName(Constante.themes_accueil);
			return model;
		}
	}

}
