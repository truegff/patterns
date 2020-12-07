package ge.lanmaster.patterns.structural.Iterator;

public interface InventoryIterator {
    boolean hasNextInventoryItem();
    InventoryItem getNextInventoryItem();
    boolean hasPrevInventoryItem();
    InventoryItem getPrevInventoryItem();
}
