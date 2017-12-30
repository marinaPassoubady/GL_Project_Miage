package com.example.project.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.validators.UserConnexionValidator;

@Controller
@SessionAttributes("theme")
@PropertySource("constante.properties")
public class Signin {
	
	private static final Logger logger = LoggerFactory.getLogger(Signin.class);
	
	@Value("${page.connexion}")
    public String pageConnexion;
	
	@Value("${page.accueil}")
    private String redirectAccueil;
	
	@Value("${list.theme}")
    private String listThemes;
	
	@Value("${objet.theme}")
    private String objTheme;
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	private UserConnexionValidator userConnexionValidator;
	
	@GetMapping("/")
	public ModelAndView signin() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", new User());
		logger.info("connexion");
		model.setViewName("connexion");
		return model;
	}
	
	@PostMapping("/")
	public ModelAndView signInProceed(@ModelAttribute User user, BindingResult result/*, HttpSession session */) {
		ModelAndView model = new ModelAndView();
		userConnexionValidator.validate(user, result);
		if(result.hasErrors()) {
			model.setViewName(pageConnexion);
			return model;
		}
		model.setViewName(redirectAccueil);
		return model;
	}
	
	@GetMapping(value="/themes")
	public ModelAndView afficherAccueil() {
		ModelAndView model = new ModelAndView();
		model.addObject("themes", blogService.getThemes());
		logger.info("test *************************** "+blogService.getThemes().size());
		model.addObject("theme", new Theme());
		model.setViewName("themes");
		return model;
	}

}
