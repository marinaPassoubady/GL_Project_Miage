package com.example.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.service.BlogService;
import com.example.project.tools.Constantes;

@Controller
public class AddArticle {
	
	@Autowired
	BlogService blogService;
	
	@PostMapping(value="theme")
	public ModelAndView ajouterArticle(@RequestParam("tId") int id, @ModelAttribute("article") @Valid Article article ,BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.addObject(Constantes.hasError, true);
			model.setViewName(Constantes.theme);
			return model;
		}
		article.setTheme(new Theme());
		article.getTheme().setId(id);
		blogService.addArticle(article);
		model.setViewName(Constantes.redirect_theme_id+id);
		return model;
	}

}
