package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;

@Service
public class BlogService implements BlogServiceInterface {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
