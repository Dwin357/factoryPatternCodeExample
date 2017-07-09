package com.fdmgroup.cereal;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;

public class PowersTest {
	
	Powers classUnderTest;
	String target = "tgt.txt";	
	
	void lowLevel() {
		classUnderTest = new Powers();
	}
	
	void highLevel() {
		classUnderTest = new Powers(15);
	}

	// Utilities
	public void wipeFile(String path) {
		File f = new File(path); // ensure file exists in unknown state
		f.delete(); // nuke file
		new File(path); // create file new
	}
	
	public boolean fileEmpty(String path) {
		File f = new File(path);
		return (f.length() == 0);
	}
	
	public void stageSave(Powers sv, String path) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
			os.writeObject(sv);
		} catch (FileNotFoundException e) {
			System.out.println("target not found setting save");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO fail setting save");
			e.printStackTrace();
		}
	}
	
	public Powers grabSave(String path) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
			return (Powers) is.readObject(); 
		} catch (ClassNotFoundException e) {
			System.out.println("legacy class not found grabbing save");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("target not found grabbing save");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO fail grabbing save");
			e.printStackTrace();
		}
		throw new IllegalStateException("grab save didn't work; unclr why");
	}	
	
	@Before
	public void setUp() throws Exception {
		lowLevel();
		wipeFile(target);
	}


	@Test
	public void testSaveHighLevel() {
		highLevel();
		
		wipeFile(target);
		assertTrue(fileEmpty(target));
		
		stageSave(classUnderTest, target);
		assertFalse(fileEmpty(target));
		
		Powers afterSave  = grabSave(target);
		assertEquals(classUnderTest.getLevel(), afterSave.getLevel());
	}
	

	@Test
	public void testSaveLowLevel() {
		lowLevel();
		
		wipeFile(target);
		assertTrue(fileEmpty(target));
		
		stageSave(classUnderTest, target);
		assertFalse(fileEmpty(target));
		
		Powers afterSave  = grabSave(target);
		assertEquals(classUnderTest.getLevel(), afterSave.getLevel());
	}	
	
	@Test
	public void testFireBallLowLvl() {
		lowLevel();
		int expected = -5;
		int actual = classUnderTest.fireBall();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFireBallHighLvl() {
		highLevel();
		int expected = -75;
		int actual = classUnderTest.fireBall();
		assertEquals(expected, actual);
	}

	@Test
	public void testCureWoundsLowLevel() {
		lowLevel();
		int expected = 3;
		int actual = classUnderTest.cureWounds();
		assertEquals(expected, actual);
	}

	@Test
	public void testCureWoundsHighLevel() {
		highLevel();
		int expected = 45;
		int actual = classUnderTest.cureWounds();
		assertEquals(expected, actual);
	}
}
