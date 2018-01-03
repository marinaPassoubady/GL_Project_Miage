package com.example.project.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

@Controller
@PropertySource("constante.properties")
public class AddArticle {
	
	@Autowired
	BlogService blogService;
	
	@Value("${objet.theme}")
    private String objTheme;
	
	@Value("${page.themeId}")
    private String pageThemeId;
	
	@Value("${verif.hasError}")
    private String hasError;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(value="theme")
	public ModelAndView ajouterArticle(@RequestParam("tId") int id, @ModelAttribute("article") @Valid Article article ,BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.addObject(hasError, true);
			model.setViewName(objTheme);
			return model;
		}
		article.setAuteur((User)session.getAttribute("user"));
		article.setTheme(new Theme());
		article.getTheme().setId(id);
		blogService.addArticle(article);
		model.setViewName(pageThemeId+id);
		return model;
	}

}
