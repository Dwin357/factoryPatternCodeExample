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

public class PlayerLegacyWrapperTest {
	
	PlayerLegacyWrapper classUnderTest;
	String target = "Game.ser";
	String name = "Arthur";
	int health = 50;
	
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
	
	public void stageSave(PlayerLegacyWrapper sv, String path) {
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
	
	public PlayerLegacyWrapper grabSave(String path) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
			return (PlayerLegacyWrapper) is.readObject();
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
		classUnderTest = new PlayerLegacyWrapper();
		classUnderTest.setHealthPoints(health);
		classUnderTest.setName(name);
		wipeFile(target);
	}

	@Test
	public void testUtilities() {
		wipeFile(target);
		assertTrue(fileEmpty(target));
		
		stageSave(classUnderTest, target);
		assertFalse(fileEmpty(target));
		
		PlayerLegacyWrapper afterSave = grabSave(target);
		assertEquals(classUnderTest.getHealthPoints(), afterSave.getHealthPoints());
		assertEquals(classUnderTest.getName(), afterSave.getName());
	}

}
