package ge.lanmaster.pattern.Iterator;

public interface InventoryIteratorIF {
    public boolean hasNextInventoryItem();
    public InventoryItem getNextInventoryItem();
    public boolean hasPrevInventoryItem();
    public InventoryItem getPrevInventoryItem();
}
