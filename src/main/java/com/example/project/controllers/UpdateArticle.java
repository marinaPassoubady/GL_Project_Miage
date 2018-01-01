package com.example.project.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.User;
import com.example.project.exceptions.ArticleInexistantException;
import com.example.project.exceptions.DejaVoteException;
import com.example.project.service.BlogService;

@Controller
@PropertySource("constante.properties")
public class UpdateArticle {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession session;	

	@Value("${page.themeId}")
    private String pageThemeId;
	
	@GetMapping(value="evalArticle")
	public ModelAndView evaluerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId, @RequestParam int val) {
		ModelAndView model = new ModelAndView();
		try {
			blogService.evaluerArticle(((User)session.getAttribute("user")).getId(), aId, val);
		} catch (ArticleInexistantException e) {
			model.setViewName(pageThemeId+tId);
			return model;
		} catch (DejaVoteException e) {
		}
		model.setViewName(pageThemeId+tId+"#"+aId);
		return model;
	}

}
