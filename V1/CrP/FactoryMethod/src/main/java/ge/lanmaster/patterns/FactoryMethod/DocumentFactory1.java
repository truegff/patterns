package ge.lanmaster.patterns.FactoryMethod;

public class DocumentFactory1 implements DocumentFactoryIF{
    public DocumentIF createDocument(String type) {
        if (type=="type1")
            return new DocumentType1();
        else if (type=="type2")
            return new DocumentType2();
        else throw new IllegalArgumentException();
    }
}
