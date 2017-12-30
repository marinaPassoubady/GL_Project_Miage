package com.example.project.repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.project.entities.Theme;
import com.example.project.entities.User;

@DataJpaTest 
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase (replace = Replace.NONE)
public class ThemeRepositoryTest {
	
	@Autowired
    private ThemeRepository tr;

	@Test
	public void test() {
		User u = new User();
		u.setId(1);
		List<Theme> theme = tr.findByAuteur(u);
		
		assertEquals("titre",theme.get(0).getTitre());
	}

}
