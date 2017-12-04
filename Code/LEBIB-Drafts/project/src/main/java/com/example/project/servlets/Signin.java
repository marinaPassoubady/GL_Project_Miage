package com.example.project.servlets;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;
import com.example.project.service.BlogServiceInterface;
import com.example.project.validators.UserSignInValidator;
import com.example.project.validators.UserSignUpValidator;

@Controller
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
	public String signUpProceed(@ModelAttribute User user, BindingResult result) {
		userSignUpValidator.validate(user, result);
		if(result.hasErrors()) return "connexion";
		return "redirect:themes";
	}
	
	@PostMapping(value="/signin")
	public String signInProceed(@Valid User user, BindingResult result) {
		userSignInValidator.validate(user, result);
		if(result.hasErrors()) return "inscription";
		//userRepository.save(user);
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
		return "themes";
	}
	
	@GetMapping(value="/themes")
	public String dashbord(Model model) {
		model.addAttribute("theme", new Theme());
		return "themes";
	}
	
}
