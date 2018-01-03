package com.example.project.service;

import java.util.List;

import com.example.project.entities.Article;
import com.example.project.entities.Theme;
import com.example.project.entities.User;
import com.example.project.exceptions.*;

public interface BlogService {
	User addUser(User user);
	User findUserByEmail(String email);
	User findUserByID(int id);
	void addTheme(Theme theme);
	List<Theme> getThemes();
	List<Theme> findThemesByAuteur(User user);
	Theme findTheme(int id) throws ThemeInexistantException;
	void addArticle(Article article);
	int evaluerArticle(int userId, int aId, int val) throws ArticleInexistantException, DejaVoteException;
	void supprimerArticle(int id);
	void supprimerTheme(int id);	
}
