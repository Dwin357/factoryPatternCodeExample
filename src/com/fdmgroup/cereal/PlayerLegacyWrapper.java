package com.fdmgroup.cereal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.fdmgroup.legacycode.Player;

public class PlayerLegacyWrapper extends Player implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private void writeObject(ObjectOutputStream os) throws IOException {
		os.defaultWriteObject();
		os.writeInt(getHealthPoints());
		os.writeUTF(getName());
	}
	
	private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
		is.defaultReadObject();
		setHealthPoints(is.readInt());
		setName(is.readUTF());
	}
}
