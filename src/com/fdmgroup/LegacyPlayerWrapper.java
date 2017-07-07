package com.fdmgroup;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.fdmgroup.serialization.game.Player;

public class LegacyPlayerWrapper extends Player implements Serializable {

	private static final long serialVersionUID = 1L;

	public LegacyPlayerWrapper() {
		super();
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException {
		os.defaultWriteObject();
		os.write(getHealthPoints());
		os.writeUTF(getName());
	}

	private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
		is.defaultReadObject();
		this.setHealthPoints(is.read());		
		this.setName(is.readUTF());
	}

}
