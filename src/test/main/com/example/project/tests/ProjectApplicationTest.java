package com.example.project.tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.project.ProjectApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProjectApplication.class)
@WebAppConfiguration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ProjectApplicationTest {

	@Test
	public void test() {
	}

}
