package com.example.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.repositories.ArticleRepository;
import com.example.project.repositories.ThemeRepository;
import com.example.project.repositories.UserRepository;

@Service
public class BlogService implements BlogServiceInterface {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ThemeRepository themeRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
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
		return userRepository.getOne(id);
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
	public Theme findThemeById(int id) {
		return themeRepository.getOne(id);
	}

	@Override
	public void addArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	@Transactional
	public void evaluerArticle(int id, int val) {
		Article article = articleRepository.getOne(id);
		article.setVotes(article.getVotes()+val);
		articleRepository.save(article);
	}


}
