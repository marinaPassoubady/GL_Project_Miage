package com.example.project.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(BlogAPI.class);	
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		logger.info(blogService.findUserByID(1).getEmail());
		return new ResponseEntity<User>(blogService.findUserByID(1), HttpStatus.FOUND);
	}

}
