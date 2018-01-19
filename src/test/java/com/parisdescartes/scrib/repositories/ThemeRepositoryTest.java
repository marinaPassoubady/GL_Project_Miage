package com.parisdescartes.scrib.repositories;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import com.parisdescartes.scrib.ProjectApplication;
import com.parisdescartes.scrib.entities.Theme;
import com.parisdescartes.scrib.entities.User;
import com.parisdescartes.scrib.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ProjectApplication.class)
//@AutoConfigureDataJpa

//@TestPropertySource("dateformat.properties")
public class ThemeRepositoryTest {
	
	/*@Autowired
	@InjectMocks
    private  UserRepository userRepo;
	
	@Autowired	
    private  ThemeRepository themeRepo;
 
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	*/
	@Test
	public void temporaire() {
		
	}
	//@Test
	/*public void testFindByEmail() throws FileNotFoundException, IOException {
		User u = new User();
		u.setNom("userNom");
		u.setPassword("pass");
		u.setConfirm(u.getPassword());
		u.setEmail("mail2@mail.fr");
		u.setPrenom("userPrenom");
		userRepo.save(u);
		
		Theme t = new Theme();
		t.setAuteur(u);
		t.setTitre("titreTheme");
		t.setDescription("desc");
		t.setCategorie("cate");
		
		themeRepo.save(t);
		Theme t2 = themeRepo.findOne(1);
		
		assertEquals(t.getCategorie(),t2.getCategorie());
		assertEquals(t.getAuteur().getNom(),t.getAuteur().getNom());
		
	}*/

}
