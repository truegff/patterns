package ge.lanmaster.patterns.structural.Iterator;

class InventoryIteratorImpl implements InventoryIterator {
    public boolean hasNextInventoryItem() {
        return false;
    }

    public InventoryItem getNextInventoryItem() {
        return null;
    }

    public boolean hasPrevInventoryItem() {
        return false;
    }

    public InventoryItem getPrevInventoryItem() {
        return null;
    }
}