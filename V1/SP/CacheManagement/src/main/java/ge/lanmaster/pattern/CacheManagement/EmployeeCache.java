package ge.lanmaster.pattern.CacheManagement;

import java.util.Hashtable;

/**
 * @author alexander
 */
class EmployeeCache {
    /**
     * We use a linked list to determine the least recently
     * used employee profile. The cache itself is implemented
     * by a Hashtable object. The Hashtable values are linked
     * list objects that refer to the actual EmployeeProfile
     * object.
     */
    private Hashtable cache = new Hashtable();
    
    /**
     * This is the head of the linked list that refers to the
     * most recently used EmployeeProfile.
     */
    LinkedList mru = null;
    
    /**
     * This is the end of the linked list that refers to the
     * least recently used EmployeeProfile.
     */
    LinkedList lru = null;
    
    /**
     * The maximum number of EmployeeProfile objects that may
     * be in the cache.
     */
    private final int MAX_CACHE_SIZE = 80;
    
    /**
     * The number of EmployeeProfile objects currentyly in the
     * cache.
     */
    private int currentCacheSize = 0;
    
    /**
     * This object manages the cleanup after the garbage
     * collector decides it is time to reclaim the storage
     * used by an EmployeeProfile.
     */
    private CleanupQueue myCleanup = new CleanupQueue();


    public void addEmployee(EmployeeProfile emp) {
        EmployeeID id = emp.getID();
        if (cache.get(id) == null) {
            // if not in cache
            // Add profile to cache
            // making it the most recent used
            if (currentCacheSize == 0) {
                // treat empty cache as a special case
                lru = mru = new LinkedList(emp);
            } else {
                // currentCacheSize > 0
                LinkedList newLink;
                if (currentCacheSize >= MAX_CACHE_SIZE) {
                    // remove least recently used
                    // EmployeeProfile from the cache
                    newLink = lru;
                    lru = newLink.previous;
                    cache.remove(id);
                    currentCacheSize--;
                    lru.next = null;
                    newLink.setProfile(emp);
                } else {
                    newLink = new LinkedList(emp);
                } // if >= MAX_CACHE_SIZE
                newLink.next = mru;
                mru.previous = newLink;
                newLink.previous = null;
                mru = newLink;
            } // if 0
            // Put the most recently used profile in cache.
            cache.put(id, mru);
            currentCacheSize++;
        } else {
            // profile already in cache
            // addEmployee shouldn't be called when the object
            // is already in cache. Since that has
            // happened, do a fetch so that object becomes
            // the most recently used.
            fetchEmployee(id);
        } // if cache.get(id)
    }
    
    /**
     * Return the EmployeeProfile associated with the given
     * EmployeeID in the cache or null if no EmployeeProfile is
     * associated with the given EmployeeID.
     */
    EmployeeProfile fetchEmployee(EmployeeID id) {
        // Remove any EmloyeeID from cache whose corresponding
        // EmloyeeProfile has been removed by the garbage
        // collector.
        myCleanup.cleanup();

        LinkedList foundLink = (LinkedList)cache.get(id);

        if (foundLink == null)
            return null; // Not in cache

        if (mru != foundLink) {
            if (foundLink == lru) {
                lru = foundLink.previous;
                lru.next = null;
            } // if lru

            if (foundLink.previous != null)
                foundLink.previous.next = foundLink.next;

            if (foundLink.next != null)
                foundLink.next.previous = foundLink.previous;

            mru.previous = foundLink;
            foundLink.previous = null;
            foundLink.next = mru;
            mru = foundLink;
        } // if currentCacheSize > 1
        return foundLink.getProfile();
    } // fetchEmployee(EmployeeID)

    /**
     * Remove the EmployeeProfile associated with the given
     * EmployeeID in the cache.
     */
    void removeEmployee(EmployeeID id) {
        LinkedList foundLink = (LinkedList)cache.get(id);
        if (foundLink != null) {
            if (mru == foundLink) {
                mru = foundLink.next;
            } // if mru
            if (foundLink == lru) {
                lru = foundLink.previous;
            } // if lru
            if (foundLink.previous != null) {
                foundLink.previous.next = foundLink.next;
            } // if foundLink.previous
            if (foundLink.next != null) {
                foundLink.next.previous = foundLink.previous;
            } // if foundLink.next
        } // if != null
    } // removeEmployee(EmployeeID)

    /**
     * Private doubly linked list class for maintaining list of
     * most recently used employee profiles. This class
     * implements the CleanupIF interface so that its instances
     * can be notified after the garbage collector decides to
     * remove an EmployeeProfile.
     */
    private class LinkedList implements CleanupIF {
        SoftReference profileReference;
        LinkedList previous;
        LinkedList next;

        public LinkedList(EmployeeProfile profile) {
            setProfile(profile);
        } // constructor(EmployeeProfile)

        private void setProfile(EmployeeProfile profile) {
            profileReference = myCleanup.createSoftReference(profile, this);
        } // setProfile(EmployeeProfile)

        EmployeeProfile getProfile() {
            return (EmployeeProfile)profileReference.get();
        } // getProfile()

        /**
         * When this method is called, the object that
         * implements it is expected to remove itself from
         * whatever data structures it is part of.
         */
        @Override
        public void extricate() {
            EmployeeProfile profile;
            profile = (EmployeeProfile)profileReference.get();
            removeEmployee(profile.getID());
        } // extricate()
    } // class LinkedList
} // class EmployeeCache
