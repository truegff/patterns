package ge.lanmaster.patterns.behavioral.snapshot;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SomeClass implements Serializable {

	public Integer a = null;
	public Integer b = null;

	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
	}

}