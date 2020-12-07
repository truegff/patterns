package ge.lanmaster.patterns.structural.CacheManagement;

import java.lang.ref.SoftReference;
import java.util.Hashtable;

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
                }
                newLink.next = mru;
                mru.previous = newLink;
                newLink.previous = null;
                mru = newLink;
            }
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
        }
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

        if (foundLink == null) {
            return null;
        }
        if (mru != foundLink) {
            if (foundLink == lru) {
                lru = foundLink.previous;
                lru.next = null;
            }

            if (foundLink.previous != null)
                foundLink.previous.next = foundLink.next;

            if (foundLink.next != null)
                foundLink.next.previous = foundLink.previous;

            mru.previous = foundLink;
            foundLink.previous = null;
            foundLink.next = mru;
            mru = foundLink;
        }
        return foundLink.getProfile();
    }

    /**
     * Remove the EmployeeProfile associated with the given
     * EmployeeID in the cache.
     */
    void removeEmployee(EmployeeID id) {
        LinkedList foundLink = (LinkedList)cache.get(id);
        if (foundLink != null) {
            if (mru == foundLink) {
                mru = foundLink.next;
            }
            if (foundLink == lru) {
                lru = foundLink.previous;
            }
            if (foundLink.previous != null) {
                foundLink.previous.next = foundLink.next;
            }
            if (foundLink.next != null) {
                foundLink.next.previous = foundLink.previous;
            }
        }
    }

    /**
     * Private doubly linked list class for maintaining list of
     * most recently used employee profiles. This class
     * implements the Cleanup interface so that its instances
     * can be notified after the garbage collector decides to
     * remove an EmployeeProfile.
     */
    private class LinkedList implements Cleanup {
        private SoftReference profileReference;
        private LinkedList previous;
        private LinkedList next;

        public LinkedList(EmployeeProfile profile) {
            setProfile(profile);
        }

        private void setProfile(EmployeeProfile profile) {
            profileReference = myCleanup.createSoftReference(profile, this);
        }

        EmployeeProfile getProfile() {
            return (EmployeeProfile)profileReference.get();
        }

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
        }
    }
}
