package com.example.project.service;

import com.example.project.entities.User;

public interface BlogServiceInterface {
	public void addUser(User user);
	User findUserByEmail(String email);
}
