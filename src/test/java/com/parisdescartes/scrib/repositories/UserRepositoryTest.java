package com.parisdescartes.scrib.repositories;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.parisdescartes.scrib.ProjectApplication;
import com.parisdescartes.scrib.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ProjectApplication.class)
//@AutoConfigureDataJpa
public class UserRepositoryTest {
	
	/*@Autowired
    private  UserRepository userRepo;
	*/
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void temporaire() {
		
	}

	//@Test
	/*public void testFindByEmail() {
		User u = new User();
		u.setNom("marina");
		u.setPassword("pass");
		u.setConfirm(u.getPassword());
		u.setEmail("mail@mail.fr");
		u.setPrenom("passoubady");
		userRepo.save(u);
		User u2 = userRepo.findByEmail("mail@mail.fr");
		assertEquals("marina",u2.getNom());
	}
	
	//@After
	public void tearDown() {
		userRepo.delete(1);
	}*/

}
