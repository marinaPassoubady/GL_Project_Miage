package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.service.BlogService;
import com.example.project.tools.Constante;

@Controller
@PropertySource("constante.properties")
public class DeleteArticle {
	
	@Autowired
	BlogService blogService;
	
	@GetMapping(value="deleteArticle")
	public ModelAndView supprimerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId) {
		ModelAndView model = new ModelAndView();
		blogService.supprimerArticle(aId);
		model.setViewName(Constante.theme_select+tId);
		return model;
	}

}
