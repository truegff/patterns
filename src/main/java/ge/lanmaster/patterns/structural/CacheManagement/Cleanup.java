package ge.lanmaster.patterns.structural.CacheManagement;

public interface Cleanup {

    /**
     * When this method is called, the object that implements it is
     * expected to remove itself from whatever data structures it is
     * part of.
     */
    void extricate();

}
