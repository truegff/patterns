package ge.lanmaster.patterns.structural.Iterator;

public class InventoryCollection {
    // ...

    public InventoryIterator iterator(){
        return new InventoryIteratorImpl();
    }


}
