package ge.lanmaster.patterns.creational.FactoryMethod.factory;

import ge.lanmaster.patterns.creational.FactoryMethod.document.Document;

public interface DocumentFactory {
    Document createDocument(String type);
}
