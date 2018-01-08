package com.example.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.exceptions.*;
import com.example.project.repositories.ArticleRepository;
import com.example.project.repositories.ThemeRepository;
import com.example.project.repositories.UserRepository;
import com.example.project.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void addTheme(Theme theme) {
		themeRepository.save(theme);
		
	}

	@Override
	public User findUserByID(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<Theme> getThemes() {
		return themeRepository.findAll();
	}

	@Override
	public List<Theme> findThemesByAuteur(User user) {
		return themeRepository.findByAuteur(user);
	}

	@Override
	public Theme findTheme(int id) throws ThemeInexistantException {
		Theme theme = themeRepository.findOne(id);
		if(theme == null) throw new ThemeInexistantException("Le theme dont l'identifiant est "+id+" n'existe pas.");
		return theme;
 	}

	@Override
	public void addArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	@Transactional
	public int evaluerArticle(int userId, int aId, int val) throws ArticleInexistantException, DejaVoteException {
		Article article = articleRepository.findOne(aId);
		if (article == null) throw new ArticleInexistantException("l'article dont l'id est "+aId+" n'existe pas");
		User user = new User();
		user.setId(userId);
		if (article.getVoteurs().contains(user)) throw new DejaVoteException("Vous avez déjà voté cet article");
		article.getVoteurs().add(user);
		article.setVotes(article.getVotes()+val);
		articleRepository.save(article);
		return article.getVotes();
	}

	@Override
	public void supprimerArticle(int id) {
		articleRepository.delete(id);
	}

	@Override
	public void supprimerTheme(int id) {
		themeRepository.delete(id);
		
	}


	
}
