package com.fdmgroup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShieldTest {
	
	private static Shield classUnderTest;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new Shield();
	}

	@Test
	public void testAttack() {
		String msg = "does this work";
		int expected = 0;
		int subject = classUnderTest.attack();
		assertEquals(msg, expected, subject);
	}

	@Test
	public void testDefense() {
		String msg = "does this work";
		int expected = 5;
		int subject = classUnderTest.defense();
		assertEquals(msg, expected, subject);
	}
	
	// tests for abstract item

}
