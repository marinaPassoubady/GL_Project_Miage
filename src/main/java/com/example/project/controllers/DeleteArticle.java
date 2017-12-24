package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.service.BlogService;

@Controller
@PropertySource("constante.properties")
public class DeleteArticle {
	
	@Autowired
	BlogService blogService;
	
	@Value("${page.themeId}")
    private String pageThemeId;
	
	public ModelAndView supprimerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId) {
		ModelAndView model = new ModelAndView();
		blogService.supprimerArticle(aId);
		model.setViewName(pageThemeId+tId);
		return model;
	}

}
