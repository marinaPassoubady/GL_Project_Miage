package com.example.project.service;

import java.util.List;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.entities.User;

public interface BlogServiceInterface {
	void addUser(User user);
	User findUserByEmail(String email);
	User findUserByID(int id);
	void addTheme(Theme theme);
	List<Theme> getThemes();
	List<Theme> findThemesByAuteur(User user);
	Theme findThemeById(int id);
	void addArticle(Article article);
	void evaluerArticle(int id, int val);
	void supprimerArticle(int id);
	void supprimerTheme(int id);
	
}
