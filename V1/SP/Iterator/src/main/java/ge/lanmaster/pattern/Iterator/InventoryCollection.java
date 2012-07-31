package ge.lanmaster.pattern.Iterator;

public class InventoryCollection {
    // ...

    public InventoryIteratorIF iterator(){
        return new InventoryIterator();
    }

    private class InventoryIterator implements InventoryIteratorIF {
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
}
