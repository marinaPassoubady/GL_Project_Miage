package com.parisdescartes.scrib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.parisdescartes.scrib.service.BlogService;
import com.parisdescartes.scrib.tools.Constante;

@Controller
public class DeleteArticle {
	
	@Autowired
	BlogService blogService;
	
	@GetMapping(value="deleteArticle")
	public ModelAndView supprimerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId) {
		ModelAndView model = new ModelAndView();
		blogService.supprimerArticle(aId);
		model.setViewName(Constante.THEME_SELECT+tId);
		return model;
	}

}
