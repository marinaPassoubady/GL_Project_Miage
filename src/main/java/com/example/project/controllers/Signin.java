package com.example.project.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.tools.Constante;

@Controller
@SessionAttributes("theme")
@PropertySource("constante.properties")
public class Signin {
	
	private static final Logger logger = LoggerFactory.getLogger(Signin.class);
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public ModelAndView signin() {
		ModelAndView model = new ModelAndView();
		model.addObject(Constante.user, new User());
		logger.info(Constante.connexion);
		model.setViewName(Constante.connexion);
		return model;
	}
	
	@GetMapping(value="/themes")
	public ModelAndView afficherAccueil(@RequestParam(value = "fetch", defaultValue="ALL") String fetch) {
		ModelAndView model = new ModelAndView();
		User user = (User)session.getAttribute(Constante.user);
		List<Theme> themes = new ArrayList<>();
		if(fetch.equalsIgnoreCase(Constante.fetch_all)) {
			themes = blogService.getThemes();
		}
		else if(fetch.equalsIgnoreCase(Constante.fetch_self)) {
			themes = blogService.findThemesByAuteur(user);
		}
		model.addObject(Constante.user,user);
		model.addObject(Constante.themes_accueil, themes);
		model.addObject(Constante.theme, new Theme());
		model.setViewName(Constante.themes_accueil);
		return model;
	}

}
