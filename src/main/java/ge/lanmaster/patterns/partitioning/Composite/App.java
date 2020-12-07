package ge.lanmaster.patterns.partitioning.Composite;

import ge.lanmaster.patterns.partitioning.Composite.elements.CompositeDocumentElement;
import ge.lanmaster.patterns.partitioning.Composite.elements.impl.Image;
import ge.lanmaster.patterns.partitioning.Composite.elements.impl.Page;

public class App {

	public static void main(String[] args) {

		System.out.println("Composite Pattern");

		CompositeDocumentElement cde = new CompositeDocumentElement() {
		};

		CompositeDocumentElement cde2 = new CompositeDocumentElement() {
		};

		CompositeDocumentElement cde3 = new CompositeDocumentElement() {
		};

		cde.addChild(cde2);
		System.out.println(cde2.getParent().toString());
		cde.addChild(new Image());
		cde2.addChild(new Page());
		cde.addChild(cde3);
		cde3.addChild(new Image());


		System.out.println(cde.getCharLength());
		cde.removeChild(cde2);
		System.out.println(cde.getCharLength());
	}
}
