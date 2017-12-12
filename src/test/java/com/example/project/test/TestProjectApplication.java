package com.example.project.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.project.ProjectApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProjectApplication.class)
@WebAppConfiguration
@ContextConfiguration(classes = ProjectApplication.class)
public class TestProjectApplication {



}
