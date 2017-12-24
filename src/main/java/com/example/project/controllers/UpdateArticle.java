package com.example.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.service.BlogService;

@Controller
@PropertySource("constante.properties")
public class UpdateArticle {
	
	@Autowired
	BlogService blogService;
	
	@Value("${page.themeId}")
    private String pageThemeId;
	
	@GetMapping(value="evalArticle")
	public ModelAndView evaluerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId, @RequestParam int val) {
		ModelAndView model = new ModelAndView();
		blogService.evaluerArticle(aId, val);
		model.setViewName(pageThemeId+tId);
		return model;
	}

}
