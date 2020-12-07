package ge.lanmaster.patterns.creational.FactoryMethod.document;

import ge.lanmaster.patterns.creational.FactoryMethod.document.Document;

public class DocumentType1 implements Document {
    public void operation1() {
        System.out.println("DocumentType1 operation1 executed.");
    }

    public void operation2() {
        System.out.println("DocumentType1 operation2 executed.");
    }
}
