package com.example.project.controllers;

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
import com.example.project.service.BlogService;

@Controller
@PropertySource("constante.properties")
public class ConsultTheme {
	
	@Autowired
	BlogService blogService;
	
	@Value("${objet.theme}")
    private String objTheme;
	
	@Value("${objet.article}")
    private String objArticle;
	
	@ModelAttribute
	@GetMapping(value="theme")
	public ModelAndView consulterTheme(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView();
		Theme theme = blogService.findThemeById(id);
		model.addObject(objTheme, theme);
		model.addObject(objArticle, new Article());
		model.setViewName(objTheme);
		return model;
	}

}
