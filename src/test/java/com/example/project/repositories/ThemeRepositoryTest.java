package com.example.project.repositories;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.parisdescartes.scrib.repositories.ThemeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ThemeRepositoryTest {
	
	@Mock
    private TestEntityManager entityManager;
 
    @Mock
    private  ThemeRepository themeRepo;
 
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
