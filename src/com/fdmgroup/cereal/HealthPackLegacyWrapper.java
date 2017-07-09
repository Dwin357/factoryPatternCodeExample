package com.fdmgroup.cereal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.fdmgroup.legacycode.HealthPack;

public class HealthPackLegacyWrapper extends HealthPack implements Serializable {

	private static final long serialVersionUID = 1L;

	public HealthPackLegacyWrapper() {
		super();
	}

	public HealthPackLegacyWrapper(int points) {
		super(points);
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException {
		os.defaultWriteObject();
		os.writeInt(getHealthPoints());
	}	
	
	private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
		is.defaultReadObject();
		setHealthPoints(is.readInt());
	}	

}
