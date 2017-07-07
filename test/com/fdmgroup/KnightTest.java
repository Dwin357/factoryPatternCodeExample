package com.fdmgroup;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KnightTest {

	private static Knight classUnderTest;
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new Knight();
	}

	@Test
	public void testKnightStartZeroHP() {
		String msg = "does this work";
		int subject = classUnderTest.getHealthPoints();
		int expected = 0;
		assertEquals(msg, expected, subject);
	}

	@Test
	public void testKnightStartsUndefinedName() {
		String msg = "does this work";
		String subject = classUnderTest.getName();
		String expected = "undefined";
		assertEquals(msg, expected, subject);
	}

	@Test
	public void testKnightSetName() {
		String msg = "does this work";
		String expected = "Lancealot";
			// tested action
			classUnderTest.setName(expected);
		String subject = classUnderTest.getName();

		assertEquals(msg, expected, subject);
	}

	@Test
	public void testKnightSetHealth() {
		String msg = "does this work";
		int expected = 1000;
			// tested action
			classUnderTest.setHealthPoints(expected);
		int subject = classUnderTest.getHealthPoints();

		assertEquals(msg, expected, subject);
	}

	
}
