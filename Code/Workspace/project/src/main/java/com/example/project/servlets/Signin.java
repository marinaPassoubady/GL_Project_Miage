package com.example.project.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;
import com.example.project.service.BlogServiceInterface;
import com.example.project.validators.UserSignInValidator;
import com.example.project.validators.UserSignUpValidator;

@Controller
@SessionAttributes("theme")
public class Signin {
	
	
	@Autowired
	BlogServiceInterface blogService;
	
	@Autowired
	private UserSignInValidator userSignInValidator;
	
	@Autowired
	private UserSignUpValidator userSignUpValidator;
	
	@GetMapping("/signin")
	public String signin(Model model) {
		model.addAttribute("user", new User());
		return "inscription";
	}
	
	@GetMapping("/")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "connexion";
	}
	@PostMapping("/")
	public String signUpProceed(@ModelAttribute User user, BindingResult result/*, HttpSession session */) {
		userSignUpValidator.validate(user, result);
		if(result.hasErrors()) return "connexion";
	//	session.setAttribute("userDetails", new User());
		return "redirect:themes";
	}
	
	@PostMapping(value="/signin")
	public String signInProceed(@Valid User user, BindingResult result) {
		userSignInValidator.validate(user, result);
		if(result.hasErrors()) return "inscription";
		blogService.addUser(user);
		return "redirect:themes";
		
	}
	@PostMapping(value="/themes")
	public String ajouterTheme(@Valid Theme theme, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("hasError", true);
			return "themes";
		}
		blogService.addTheme(theme);
		return "redirect:themes";
	}
	
	@GetMapping(value="/themes")
	public String dashbord(Model model) {
		model.addAttribute("themes", blogService.getThemes());
		model.addAttribute("theme", new Theme());
		return "themes";
	}
	
	@ModelAttribute
	@GetMapping(value="theme")
	public String consulterTheme(@RequestParam("id") int id,  Model model) {
		Theme theme = blogService.findThemeById(id);
		model.addAttribute("theme", theme);
		Article article = new Article();
		model.addAttribute("article", article);
		return "theme";
	}
	
	@PostMapping(value="theme")
	public String ajouterArticle(@RequestParam("tId") int id, @ModelAttribute("article") @Valid Article article ,BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("hasError", true);
			return "theme";
		}
		article.setTheme(new Theme());
		article.getTheme().setId(id);
		blogService.addArticle(article);
		return "redirect:theme?id="+id;
	}
	
	@GetMapping(value="evalArticle")
	public String evaluerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId, @RequestParam int val) {
		blogService.evaluerArticle(aId, val);
		return "redirect:theme?id="+tId;
	}
	
	@GetMapping(value="deleteArticle")
	public String supprimerArticle(@RequestParam("tId") int tId, @RequestParam("aId") int aId) {
		blogService.supprimerArticle(aId);
		return "redirect:theme?id="+tId;
	}
}
