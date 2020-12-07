package ge.lanmaster.patterns.creational.FactoryMethod.factory;

import ge.lanmaster.patterns.creational.FactoryMethod.document.Document;
import ge.lanmaster.patterns.creational.FactoryMethod.document.DocumentType1;
import ge.lanmaster.patterns.creational.FactoryMethod.document.DocumentType2;

public class DocumentFactory1 implements DocumentFactory {
	public Document createDocument(String type) {
		if (type == "type1")
			return new DocumentType1();
		else if (type == "type2")
			return new DocumentType2();
		else throw new IllegalArgumentException();
	}
}
