package com.example.project.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;

@Controller
public class Signin {
	

	@Autowired 
	private UserRepository userRepository;
	
	
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
	public String signUpProceed(@ModelAttribute User user, Model model) {
		User u = userRepository.findByEmail(user.getEmail());
		if(u == null) return "connexion";
		return "themes";
	}
	
	@PostMapping(value="/signin")
	public String signInProceed(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		userRepository.save(user);
		return "redirect:";
		
	}
	
}
