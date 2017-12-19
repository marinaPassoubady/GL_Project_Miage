package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.service.BlogService;
import com.example.project.tools.Constantes;

@Controller
public class DeleteArticle {
	
	@Autowired
	BlogService blogService;
	
	public ModelAndView supprimerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId) {
		ModelAndView model = new ModelAndView();
		blogService.supprimerArticle(aId);
		model.setViewName(Constantes.redirect_theme_id+tId);
		return model;
	}

}
