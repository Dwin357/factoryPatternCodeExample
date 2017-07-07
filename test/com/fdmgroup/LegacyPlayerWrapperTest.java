package com.fdmgroup;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;

public class LegacyPlayerWrapperTest {
	
	String targetFile = "knight.txt";
	String pcName = "Arthur";
	int pcHealth = 50;
	LegacyPlayerWrapper classUnderTest;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new LegacyPlayerWrapper();
		classUnderTest.setName(pcName);
		classUnderTest.setHealthPoints(pcHealth);
		wipeFile(targetFile);
	}
	
	void wipeFile(String target) {
		File f = new File(target);
		f.delete();
		new File(target);
	}

	public void setSaveFile(String target, LegacyPlayerWrapper sv) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(target));
			os.writeObject(sv);
			os.close();
		} catch (IOException e) {
			System.out.println("Save File Setter Failed");
			e.printStackTrace();
		}
	}
	
	public LegacyPlayerWrapper getSaveFile(String target) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target));
			LegacyPlayerWrapper saved = (LegacyPlayerWrapper) ois.readObject();
			ois.close();
			return saved;
		} catch (ClassNotFoundException e) {
			System.out.println("Save File Getter Failed Class");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Save File Getter Failed IO");
			e.printStackTrace();
		}
		throw new IllegalArgumentException("get save file failed");
	}
	
	@Test
	public void testTheTestSetup() {
		LegacyPlayerWrapper beforeWrite = classUnderTest;
		File file;

		// save exists and file empty
		wipeFile(targetFile);
		file = new File(targetFile);
		assertEquals(0, file.length());
		
		// save file not empty
		setSaveFile(targetFile, beforeWrite);
		file = new File(targetFile);
		assertNotEquals(0, file.length());
		
		// object from file
		LegacyPlayerWrapper afterWrite = getSaveFile(targetFile);
		assertEquals(beforeWrite.getHealthPoints(), afterWrite.getHealthPoints());
		assertEquals(beforeWrite.getName(), afterWrite.getName());						

		// clears file
		wipeFile(targetFile);
		file = new File(targetFile);
		assertEquals(0, file.length());
	}
	
	@Test
	public void testWriteObject(){
		setSaveFile(targetFile, classUnderTest);
		File file = new File(targetFile);
		assertNotEquals(0, file.length());		
	}
	
	@Test
	public void testReadObject() {
		setSaveFile(targetFile, classUnderTest);
		LegacyPlayerWrapper afterWrite = getSaveFile(targetFile);
		assertEquals(classUnderTest.getHealthPoints(), afterWrite.getHealthPoints());
		assertEquals(classUnderTest.getName(), afterWrite.getName());		
	}

}
