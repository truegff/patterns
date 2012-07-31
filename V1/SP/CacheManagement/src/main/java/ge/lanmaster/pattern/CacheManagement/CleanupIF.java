package ge.lanmaster.pattern.CacheManagement;

/**
 * @author alexander
 */
interface CleanupIF {

    /**
     * When this method is called, the object that implements it is
     * expected to remove itself from whatever data structures it is
     * part of.
     */
    public void extricate();
} // interface CleanupIF

