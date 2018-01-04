package com.example.project.controllers;

import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.entities.User;
import com.example.project.service.BlogService;
import com.example.project.tools.Constante;
import com.example.project.validators.UserInscriptionValidator;

@Controller
@PropertySource("constante.properties")
public class Signup {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	@Qualifier("afterSignup")
	AuthenticationProvider authManager;
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	private UserInscriptionValidator userInscriptionValidator;
	
	@GetMapping("/signup")
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.addObject(Constante.user, new User());
		model.setViewName(Constante.inscription);
		return model;
	}
	
	@PostMapping(value="/signup")
	public String signUpProceed(@Valid User user, BindingResult result) {
		userInscriptionValidator.validate(user, result);
		if(result.hasErrors()) return Constante.inscription;
		user = blogService.addUser(user);
		System.out.println("*****************"+user.getConfirm());
		System.out.println("*****************");
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
	            (user.getEmail(), user.getPassword(), Collections.emptyList());
		token.setDetails(user);
		Authentication authentication = authManager.authenticate(token);
		session.setAttribute(Constante.user, user);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		return Constante.accueil;
	}

}
