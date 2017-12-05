package com.example.project.service;

import com.example.project.entities.Theme;
import com.example.project.entities.User;

public interface BlogServiceInterface {
	void addUser(User user);
	User findUserByEmail(String email);
	User findUserByID(int id);
	void addTheme(Theme theme);
	
}
