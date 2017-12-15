package com.example.project.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entities.User;
import com.example.project.service.BlogService;

@RestController
@RequestMapping("/rest")
public class BlogAPI {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		System.out.println(blogService.findUserByID(1).getEmail());
		return new ResponseEntity<User>(blogService.findUserByID(1), HttpStatus.FOUND);
	}

}
