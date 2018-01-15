package com.example.project.exception;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.project.exceptions.DejaVoteException;

public class DejaVoteExceptionTest {
	DejaVoteException exp;

	@Before
	public void setUp() throws Exception {
	
	exp = new DejaVoteException("mon message");
	}

	@Test
	public void getMessageTest() {
		assertEquals("mon message",exp.getMessage());
	}

}
