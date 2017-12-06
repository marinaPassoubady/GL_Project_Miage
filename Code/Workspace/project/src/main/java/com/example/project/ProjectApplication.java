package com.example.project;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@ComponentScan
public class ProjectApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
}
