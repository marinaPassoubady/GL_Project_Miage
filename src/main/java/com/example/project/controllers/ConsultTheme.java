package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.service.BlogService;
import com.example.project.tools.Constantes;

@Controller
public class ConsultTheme {
	
	@Autowired
	BlogService blogService;	
	
	@ModelAttribute
	@GetMapping(value="theme")
	public ModelAndView consulterTheme(@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView();
		Theme theme = blogService.findThemeById(id);
		model.addObject(Constantes.theme, theme);
		model.addObject("article", new Article());
		model.setViewName(Constantes.theme);
		return model;
	}

}
