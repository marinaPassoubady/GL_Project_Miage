package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.service.BlogService;
import com.example.project.tools.Constantes;

@Controller
public class UpdateArticle {
	
	@Autowired
	BlogService blogService;
	
	@GetMapping(value="evalArticle")
	public ModelAndView evaluerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId, @RequestParam int val) {
		ModelAndView model = new ModelAndView();
		blogService.evaluerArticle(aId, val);
		model.setViewName(Constantes.redirect_theme_id+tId);
		return model;
	}

}
