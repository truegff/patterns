package ge.lanmaster.patterns.creational.FactoryMethod;

import ge.lanmaster.patterns.creational.FactoryMethod.document.Document;
import ge.lanmaster.patterns.creational.FactoryMethod.factory.DocumentFactory;
import ge.lanmaster.patterns.creational.FactoryMethod.factory.DocumentFactory1;

public class App {
	public static void main(String[] args) {
		System.out.println("FactoryMethod Pattern");

		DocumentFactory factory = new DocumentFactory1();
		Document document = factory.createDocument("type1");

		document.operation1();
		document.operation2();

		document = factory.createDocument("type2");

		document.operation1();
		document.operation2();
	}
}
