package com.example.project.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.tools.Constante;

@Controller
@PropertySource("constante.properties")
public class AddArticle {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value="theme")
	public ModelAndView ajouterArticle(@RequestParam("tId") int id, @ModelAttribute("article") @Valid Article article ,BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.addObject(Constante.ERREUR, true);
			model.setViewName(Constante.THEME);
			return model;
		}
		article.setAuteur((User)session.getAttribute(Constante.USER));
		article.setTheme(new Theme());
		article.getTheme().setId(id);
		blogService.addArticle(article);
		model.setViewName(Constante.THEME_SELECT+id);
		return model;
	}

}
