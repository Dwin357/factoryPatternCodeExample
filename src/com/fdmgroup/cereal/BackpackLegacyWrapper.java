package com.fdmgroup.cereal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.fdmgroup.legacycode.Backpack;
import com.fdmgroup.legacycode.HealthPack;

public class BackpackLegacyWrapper extends Backpack implements Serializable {

	private static final long serialVersionUID = 1L;

	public BackpackLegacyWrapper() {
		super();
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException {
		os.defaultWriteObject();
		os.writeObject(packContents());
	}	
	
	private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
		is.defaultReadObject();
		@SuppressWarnings("unchecked")
		ArrayList<HealthPack> contents = ((ArrayList<HealthPack>) is.readObject());
		repackContents(contents);
	}	
	
	private ArrayList<HealthPack> packContents() {
		ArrayList<HealthPack> contents = new ArrayList<HealthPack>();
		int size = getNumPacks();
		for (int i = 0; i < size; i++) {
			contents.add(useHealthPack());
		}
		for (int i = 0 ; i < size ; i++) {
			addHealthPack(contents.get((i)));
		}
		return contents;
	}
	
	private void repackContents(ArrayList<HealthPack> contents) {
		for(HealthPack pack : contents) {
			addHealthPack(pack);
		}
	}

}
