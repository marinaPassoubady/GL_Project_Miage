package com.example.project.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

@Controller
@PropertySource("constante.properties")
public class ConsultTheme {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	@Value("${objet.theme}")
    private String objTheme;
	
	@Value("${page.accueil}")
    private String redirectThemes;
	
	@Value("${objet.article}")
    private String objArticle;
	
	@ModelAttribute
	@GetMapping(value="theme")
	public ModelAndView consulterTheme(@RequestParam("id") int id) {
		
		ModelAndView model = new ModelAndView();
		try {
			Theme theme = blogService.findTheme(id);
			model.addObject(objTheme, theme);
			Article article = new Article();
			model.addObject(objArticle, article);
			model.addObject("user", (User)session.getAttribute("user"));
			model.setViewName(objTheme);
			return model;
		} catch (ThemeInexistantException e) {
			model.setViewName(redirectThemes);
			return model;
		}
	}

}
